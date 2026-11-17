package com.sd.Models;

public class OrderItem{
    private int orderId;
    private int productId;
    private Product product;
    private int quantity;
    private int unitPricecents;
    private Timestamp createdAt;

    public OrderItem(int orderId, int productId, Product product, int quantity, int unitPricecents) {
        this.orderId = orderId;
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
        this.unitPricecents = unitPricecents;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public int getProductId() {
        return this.productId;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getUnitPricecents() {
        return this.unitPricecents;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public int setOrderId(int orderId) {
        return this.orderId = orderId;
    }

    public int setProductId(int productId) {
        return this.productId = productId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int setQuantity(int quantity) {
        return this.quantity = quantity;
    }

    public int setUnitPricecents(int unitPricecents) {
        return this.unitPricecents = unitPricecents;
    }

    public Timestamp setCreatedAt(Timestamp createdAt) {
        return this.createdAt = createdAt;
    }

    public String toString() {
        return "OrderItem{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPricecents=" + unitPricecents +
                ", createdAt=" + createdAt +
                '}';
    }
}

