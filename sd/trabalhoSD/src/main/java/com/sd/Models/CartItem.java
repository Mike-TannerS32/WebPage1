package com.sd.Models;

import java.sql.Timestamp;

public class CartItem {
    private int id;
    private int customerId;
    private int productid;
    private Product product;
    private int quantity;
    private Timestamp createdAt;

    public CartItem() {}

    public CartItem(int id, int customerId, int productid, Product product, int quantity, Timestamp createdAt) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public int getId(){
        return this.id;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public int getProductId(){
        return this.productid;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setProductId(int productid) {
        this.productid = productid;
    }

    public void setProduct(Product product){
        this.product = product;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public void incrementQuantity(int amount){
        this.quantity += amount;
    }

    public void decrementQuantity(int amount){
        this.quantity -= amount;
    }
    
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productid=" + productid +
                ", product=" + product +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                '}';
    }
}