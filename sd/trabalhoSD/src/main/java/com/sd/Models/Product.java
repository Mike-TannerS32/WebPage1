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

    public Product() {}

    public Product(int id, String name, String category, String description, String photo, int price, int stock, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDescription(){
        return this.description;
    }

    public String getPhoto(){
        return this.photo;
    }

    public int getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public String getStatus(){
        return this.status;
    }

    public int setId(int id){
        this.id = id;
        return id;
    }

    public String setName(String name){
        this.name = name;
        return name;
    }

    public String setCategory(String category){
        this.category = category;
        return category;
    }

    public String setDescription(String description){
        this.description = description;
        return description;
    }

    public String setPhoto(String photo){
        this.photo = photo;
        return photo;
    }

    public int setPrice(int price){
        this.price = price;
        return price;
    }

    public int setStock(int stock){
        this.stock = stock;
        return stock;
    }

    public String setStatus(String status){
        this.status = status;
        return status;
    }

    public String toString(){
        return "Product(id=" + id + ", name=" + name + ", category=" + category + ", description=" + description + ", photo=" + photo + ", price=" + price + ", stock=" + stock + ", status=" + status + ")";
    }
}