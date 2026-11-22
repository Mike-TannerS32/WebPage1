package com.sd.Models;

import java.sql.Timestamp;

public class Order{
    private Integer id;
    private Integer customerId;
    private int totalPrice;
    private String status;
    private Timestamp createdAt;

    public Order() {}

    public Order(Integer id, Integer customerId, int totalPrice, String status, Timestamp createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return this.id;
    }
    
    public Integer getCustomerId(){
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

    public Integer setId(Integer id){
        return this.id = id;
    }

    public Integer setCustomerId(Integer customerId){
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