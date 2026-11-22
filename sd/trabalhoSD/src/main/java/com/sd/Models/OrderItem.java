package com.sd.Models;

public class OrderItem{
    private Integer orderId;
    private Integer productId;
    private Product product;
    private int quantity;
    private int unitPricecents;

    public OrderItem() {}

    public OrderItem(Integer orderId, Integer productId, Product product, int quantity, int unitPricecents) {
        this.orderId = orderId;
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
        this.unitPricecents = unitPricecents;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Integer getProductId() {
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


    public Integer setOrderId(Integer orderId) {
        return this.orderId = orderId;
    }

    public Integer setProductId(Integer productId) {
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

    public String toString() {
        return "OrderItem{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPricecents=" + unitPricecents +
                '}';
    }
}

