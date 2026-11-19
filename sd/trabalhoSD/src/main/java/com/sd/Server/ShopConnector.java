package com.sd.Server;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import com.sd.Models.Customer;
import com.sd.Models.Order;
import com.sd.Models.Product;
import com.sd.Models.CartItem;
import com.sd.Models.OrderItem;

@Component
public class ShopConnector {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShopConnector(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //cliente
    // criar conta do cliente
    public Boolean createCustomer(Customer customer){
        String str = "INSERT INTO customers (name, email) VALUES (?, ?)";

        System.out.println(customer.toString());
        jdbcTemplate.update(str, customer.getName(), customer.getEmail());

        return true;
    }


    //admin
    //criar um produto
    public Boolean createProduct(Product product){
        String str = "INSERT INTO products (name,category,description, photo,price_cents, stock, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        System.out.println(product.toString());
        jdbcTemplate.update(str, product.getName(), product.getCategory(), product.getdescription(), product.getPhoto(),product.getPrice(),product.getStock(), product.getStatus());

        return true;
    }

    //listar todos os produtos
    public List<Product> getProducts(){
        String str = "SELECT * FROM products";
        return jdbcTemplate.query(str, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price_cents"));
                return product;
            }
        });
    }

    public List<Product> getProductsByStatus(String status){
        String str = "SELECT * FROM products WHERE status = ?";
        return jdbcTemplate.query(str, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price_cents"));
                System.out.println(product);
                return product;
            }
        }, status);
    }

    //devolve um produto por id
    public Product getProductById(int id){
        String str = "SELECT * FROM products WHERE ID = ?";
        return jdbcTemplate.queryForObject(str, new Object[]{id}, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                return product;
            }
        });
    }

    //criar um item no carrinho
    public Boolean createCartItem(CartItem cartItem){
        String str = "INSERT INTO cart_items (product_id, customer_id, quantity) Values (?, ?)";
        jdbcTemplate.update(str, cartItem.getProductId(), cartItem.getCustomerId,cartItem.getQuantity());
        return true;
    }

    // listar todos os itens do carrinho
    public List<CartItem> getCartItems(){
        String str = "SELECT * FROM cart_items WHERE customerId = ?";
        return jdbcTemplate.query(str, new RowMapper<CartItem>(){
            public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException{
                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getInt("id"));
                cartItem.setProductId(rs.getInt("product_id"));
                cartItem.setCustomerId(rs.getInt("customer_id"));
                cartItem.setQuantity(rs.getInt("quantity"));
                return cartItem;
            }
        });
    }

    // retira um item do carrinho
    public Boolean removeCartItem(int id){
        String str = "DELETE FROM cart_items WHERE customer_id = ? AND product_id = ?";
        jdbcTemplate.update(str, id);
        return true;
    }

    //cria uma encomenda
    public Boolean createOrder(Order order){
        String str = "INSERT INTO orders (customer_id, total_cents) VALUES (?, ?) RETURNING id";

        System.out.println(order.toString());
        jdbcTemplate.update(str, order.getCustomerId(), order.getTotalPrice());

        return true;
    }

    // cria um item de encomenda
    public Boolean createOrderItem(OrderItem orderItem){
        String str = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

        System.out.println(orderItem.toString());
        jdbcTemplate.update(str, orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity());

        return true;
    }

    // lista todos os itens da encomenda
    public List<OrderItem> getOrderItems(){
        String str = "SELECT * FROM order_items";
        return jdbcTemplate.query(str, new RowMapper<OrderItem>(){
            public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException{
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(rs.getInt("order_id"));
                orderItem.setProductId(rs.getInt("product_id"));
                orderItem.setQuantity(rs.getInt("quantity"));
                return orderItem;
            }
        });
    }

    // retira um item da encomenda
    public Boolean removeOrderItem(int id){
        String str = "DELETE FROM order_items WHERE id = ?";
        jdbcTemplate.update(str, id);
        return true;
    }

    //lista todas as encomendas
    public List<Order> getOrders(){
        String str = "SELECT * FROM orders";
        return jdbcTemplate.query(str, new RowMapper<Order>(){
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException{
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setTotalPrice(rs.getDouble("total_cents"));
                return order;
            }
        });
    }
}