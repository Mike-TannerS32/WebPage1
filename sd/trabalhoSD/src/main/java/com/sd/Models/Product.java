package com.sd.Models;

public class Product{
    private int id;
    private String name;
    private String category;
    private String description;
    private String photo;
    private int price;
    private int stock;
    private String status;
    private Timestamp createdAt;

    public Product(int id, String name, String category, String description, String photo, int price, int stock, String status, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public String getDescription(){
        return description;
    }

    public String getPhoto(){
        return photo;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public String getStatus(){
        return status;
    }

    public Timestamp getCreatedAt(){
        return createdAt;
    }   
}