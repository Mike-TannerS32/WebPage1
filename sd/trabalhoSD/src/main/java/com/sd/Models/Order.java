package com.sd.Models;

public class Order{
    private int id;
    privat int customerId;
    private int totalPrice;
    private String status;
    private Timestamp createdAt;

    public Order(int id, int customerId, int totalPrice, String status) {
        this.id = id;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }
    
    public int getCustomerId(){
        return this.customerId;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

    public String getStatus(){
        return this.status;
    }

    public Timestamp getCreatedAt(){
        return this.createdAt;
    }

    public int setId(int id){
        return this.id = id;
    }

    public int setCustomerId(int customerId){
        return this.customerId = customerId;
    }

    public int setTotalPrice(int totalPrice){
        return this.totalPrice = totalPrice;
    }

    public String setStatus(String status){
        return this.status = status;
    }

    public Timestamp setCreatedAt(Timestamp createdAt){
        return this.createdAt = createdAt;
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}