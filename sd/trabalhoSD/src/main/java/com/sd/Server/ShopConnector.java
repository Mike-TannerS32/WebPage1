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
    };

    private final RowMapper<CartItem> cartItemMapper = (rs, i) -> {
        CartItem c = new CartItem();
        c.setCustomerId(rs.getInt("customer_id"));
        c.setProductId(rs.getInt("product_id"));
        c.setQuantity(rs.getInt("quantity"));
        return c;
    };

    private final RowMapper<Order> orderMapper = (rs, i) -> {
        Order o = new Order();
        o.setId(rs.getInt("id"));
        o.setCustomerId(rs.getInt("customer_id"));
        o.setTotalPrice(rs.getInt("total_cents"));
        o.setStatus(rs.getString("status"));
        return o;
    };

    private final RowMapper<OrderItem> orderItemMapper = (rs, i) -> {
        OrderItem oi = new OrderItem();
        oi.setOrderId(rs.getInt("order_Id"));
        oi.setProductId(rs.getInt("product_Id"));
        oi.setUnitPricecents(rs.getInt("total_cents"));
        return oi;
    };

    //cliente
    // criar conta do cliente
    public int createCustomer(Customer c) throws SQLException{
        return jdbcTemplate.queryForObject(
            "INSERT INTO customers (name, email) VALUES (?, ?)",
            Integer.class,  c.getName(), c.getEmail());
    }


    //admin
    //criar um produto
    public int createProduct(Product p) throws SQLException{
        return jdbcTemplate.queryForObject(
            "INSERT INTO products (name,category,description, photo,price_cents, stock, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            Integer.class, p.getName(), p.getCategory(), p.getDescription(),
            p.getPhoto(),p.getPrice(),p.getStock(), p.getStatus()
        );
    }

    public boolean updateProduct(int id, Product p) throws SQLException{
        return jdbcTemplate.update("UPDATE products SET name=?, category=?, description=?, photo=?, price_cents=?, stock=?, status=?",
        p.getName(), p.getCategory(), p.getDescription(), p.getPhoto(), p.getPrice(), p.getStock(), id) > 0;
    }

    public int setProductStatus(int id, String status) throws SQLException{
        return jdbcTemplate.update("UPDATE products SET status=? WHERE i=?",status, id);
    }

    //listar todos os produtos
    public List<Product> getProducts() throws SQLException{
        return jdbcTemplate.query("SELECT * FROM products", productMapper);
    }

    public List<Product> getProductsByStatus(String status) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM products WHERE status = ?", productMapper, status);
    }

    //devolve um produto por id
    public Product getProductById(int id) throws SQLException{
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE Id = ?", productMapper, id);
    }

    //criar um item no carrinho
    public Boolean addToCart(int customer_id, int product_id, int quantity) throws SQLException{
        return jdbcTemplate.update("INSERT INTO cart_items (product_id, customer_id, quantity) Values (?, ?)",
                             product_id, customer_id, quantity) > 0;
    }

    // listar todos os itens do carrinho
    public List<CartItem> getCartItems(int customer_id) throws SQLException{
        return jdbcTemplate.query("SELECT * FROM cart_items WHERE customer_id = ?", cartItemMapper, customer_id);
    }

    // retira um item do carrinho
    public Boolean removeCartItem(int customer_id, int product_Id) throws SQLException{
        return jdbcTemplate.update("DELETE FROM cart_items WHERE customer_id = ? AND product_id = ?", 
                                    customer_id, product_Id) > 0;
    }

    public void clearCart(int customer_id){
        jdbcTemplate.update("DELETE FROM cart_items WHERE customer_id = ?", customer_id);
    }

    //cria uma encomenda
    public int createOrder(int customer_id, int total_cents) throws SQLException{
        return jdbcTemplate.queryForObject("INSERT INTO orders (customer_id, total_cents) VALUES(?, ?) RETURNING id",
         Integer.class,customer_id, total_cents);
    }

    // cria um item de encomenda
    public Boolean createOrderItem(OrderItem oi) throws SQLException{
        System.out.println(oi.toString());
        return jdbcTemplate.update("INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)", 
            oi.getOrderId(), oi.getProductId(), oi.getQuantity()) > 0;
    }

    // lista todos os itens da encomenda
    public List<OrderItem> getOrderItems() throws SQLException{
        return jdbcTemplate.query("SELECT * FROM order_items", orderItemMapper);
    }

    //lista todas as encomendas
    public List<Order> getOrders() throws SQLException{
        return jdbcTemplate.query("SELECT * FROM orders", orderMapper);
    }

    public List<Order> getOrdersByCustomer(int customer_id){
        return jdbcTemplate.query("SELECT * FROM orders WHERE customer_id = ?", orderMapper, customer_id);
    }

    // lista as encomendas que têm determinado estado
    public List<Order> getOrderByStatus(String status){
        return jdbcTemplate.query("SELECT * FROM orders WHERE status=?", orderMapper, status);
    }

    public boolean setOrderStatus(int id, String status){
        return jdbcTemplate.update("UPDATE orders SET status = ? WHERE id = ?", status, id) > 0;
    }
}