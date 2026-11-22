package com.sd.Models;

import java.sql.Timestamp;

public class CartItem {
    private Integer id;
    private Integer customerId;
    private Integer productid;
    private Product product;
    private int quantity;
    private Timestamp createdAt;

    public CartItem() {}

    public CartItem(Integer id, Integer customerId, Integer productid, Product product, int quantity, Timestamp createdAt) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

    public Integer getId(){
        return this.id;
    }

    public Integer getCustomerId(){
        return this.customerId;
    }

    public Integer getProductId(){
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setProductId(Integer productid) {
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