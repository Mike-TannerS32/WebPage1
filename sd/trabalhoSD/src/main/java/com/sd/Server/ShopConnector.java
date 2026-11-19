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

    // Mapeadores

    private final RowMapper<Product> productMapper = (rs, i) -> {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setCategory(rs.getString("category"));
        p.setDescription(rs.getString("description"));
        p.setPhoto(rs.getString("photo"));
        p.setPrice(rs.getInt("price_cents"));
        p.setStock(rs.getInt("stock"));
        p.setStatus(rs.getString("status"));
        return p;
    }

    private final RowMapper<CartItem> cartItemMapper = (rs, i) -> {
        CartItem c = new CartItem();
        c.setCustomerId(rs.getInt("customer_id"));
        c.setProductId(rs.getInt("product_id"));
        c.setQuantity(rs.getInt("quantity"));
        return c;
    }

    private final RowMapper<Order> orderMapper = (rs, i) -> {
        Order o = new Order();
        o.setId(rs.getInt("id"));
        o.setCustomerId(rs.getInt("customer_id"));
        o.setTotalPrice(rs.getInt("total_cents"));
        o.setStatus(rs.getString("status"));
        return o;
    }

    private final RowMapper<OrderItem> orderItemMapper = (rs, i) -> {
        OrderItem oi = new OrderItem();
        oi.setOrderId(rs.getInt("order_Id"));
        oi.setProductId(rs.getInt("product_Id"));
        oi.setTotalPrice(rs.getInt("total_cents"));
        oi.setStatus(rs.getString("status"));
        return oi;
    }

    //cliente
    // criar conta do cliente
    public int createCustomer(Customer c){
        return jdbcTemplate.queryForObject(
            "INSERT INTO customers (name, email) VALUES (?, ?)",
            Integer.class,  c.getName(), c.getEmail());
    }


    //admin
    //criar um produto
    public int createProduct(Product p){
        return jdbcTemplate.queryForObject(
            "INSERT INTO products (name,category,description, photo,price_cents, stock, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            Integer.class, p.getName(), p.getCategory(), p.getDescription(),
            p.getPhoto(),p.getPrice(),p.getStock(), p.getStatus()
        );
    }

    public boolean updateProduct(int id, Product p){
        return jdbcTemplate.update("UPDATE products SET name=?, category=?, description=?, photo=?, price_cents=?, stock=?, status=?",
        p.getName(), p.getCategory(), p.getDescription(), p.getPhoto(), p.getPrice(), p.getStock(), id) > 0;
    }

    public boolean setProductStatus(int id, String status){
        return jdbcTemplate.update("UPDATE products SET status=? WHERE i=?",status, id);
    }

    //listar todos os produtos
    public List<Product> getProducts(){
        String str = "SELECT * FROM products";
        return jdbcTemplate.query(str, productMapper);
    }

    public List<Product> getProductsByStatus(String status){
        String str = "SELECT * FROM products WHERE status = ?";
        return jdbcTemplate.query(str, productMapper, status);
    }

    //devolve um produto por id
    public Product getProductById(int id){
        String str = "SELECT * FROM products WHERE Id = ?";
        return jdbcTemplate.queryForObject(str, productMapper, id);
    }

    //criar um item no carrinho
    public Boolean createCartItem(CartItem cartItem){
        String str = "INSERT INTO cart_items (product_id, customer_id, quantity) Values (?, ?)";
        jdbcTemplate.update(str, cartItem.getProductId(), cartItem.getCustomerId(), cartItem.getQuantity());
        return true;
    }

    // listar todos os itens do carrinho
    public List<CartItem> getCartItemsByCustomerId(){
        return jdbcTemplate.query("SELECT * FROM cart_items WHERE customer_id = ?", cartItemMapper);
    }

    // retira um item do carrinho
    public Boolean removeCartItem(int customer_id, int product_Id){
        String str = "DELETE FROM cart_items WHERE customer_id = ? AND product_id = ?";
        jdbcTemplate.update(str, customer_id, product_id);
        return true;
    }

    //cria uma encomenda
    public Boolean createOrder(int customer_id, int total_cents){
        return jdbcTemplate.queryForObject("INSERT INTO orders (customer_id, total_cents) VALUES(?, ?) RETURNING id",
         Integer.class,customer_id, total_cents);
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