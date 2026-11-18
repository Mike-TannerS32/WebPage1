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
    public Boolean createCustomer(customer customer){
        String str = "INSERT INTO customers (name, email) VALUES (?, ?)";

        System.out.println(customer.toString());
        jdbcTemplate.update(str, customer.getName(), customer.getEmail());

        return true;
    }


    //admin
    public Boolean createProduct(Product product){
        String str = "INSERT INTO products (name, price) VALUES (?, ?)";
        
        System.out.println(product.toString());
        jdbcTemplate.update(str, product.getName(), product.getPrice());

        return true;
    }

    public List<Product> getProducts(){
        String str = "SELECT * FROM products";
        return jdbcTemplate.query(str, new RowMapper<Product>() {
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                return product;
            }
        });
    }

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

    public Boolean createCartItem(CartItem cartItem){
        String str = "INSERT INTO cart_items (product_id, quantity) Values (?, ?)";
        jdbcTemplate.update(str, cartItem.getProductId(), cartItem.getQuantity());
        return true;
    }

    public List<CartItem> getCartItems(){
        String str = "SELECT * FROM cart_items";
        return jdbcTemplate.query(str, new RowMapper<CartItem>(){
            public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException{
                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getInt("id"));
                cartItem.setProductId(rs.getInt("product_id"));
                cartItem.setQuantity(rs.getInt("quantity"));
                return cartItem;
            }
        });
    }

    public Boolean removeCartItem(int id){
        String str = "DELETE FROM cart_items WHERE id = ?";
        jdbcTemplate.update(str, id);
        return true;
    }

    public Boolean createOrder(Order order){
        String str = "INSERT INTO orders (customer_id, total_price) VALUES (?, ?)";

        System.out.println(order.toString());
        jdbcTemplate.update(str, order.getCustomerId(), order.getTotalPrice());

        return true;
    }

    public Boolean createOrderItem(OrderItem orderItem){
        String str = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";

        System.out.println(orderItem.toString());
        jdbcTemplate.update(str, orderItem.getOrderId(), orderItem.getProductId(), orderItem.getQuantity());

        return true;
    }

    public List<OrderItem> getOrderItems(){
        String str = "SELECT * FROM order_items";
        return jdbcTemplate.query(str, new RowMapper<OrderItem>(){
            public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException{
                OrderItem orderItem = new OrderItem();
                orderItem.setId(rs.getInt("id"));
                orderItem.setOrderId(rs.getInt("order_id"));
                orderItem.setProductId(rs.getInt("product_id"));
                orderItem.setQuantity(rs.getInt("quantity"));
                return orderItem;
            }
        });
    }

    public Boolean removeOrderItem(int id){
        String str = "DELETE FROM order_items WHERE id = ?";
        jdbcTemplate.update(str, id);
        return true;
    }

    public List<Order> getOrders(){
        String str = "SELECT * FROM orders";
        return jdbcTemplate.query(str, new RowMapper<Order>(){
            public Order mapRow(ResultSet rs, int rowNum) throws SQLException{
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setTotalPrice(rs.getDouble("total_price"));
                return order;
            }
        });
    }
}