package com.sd.Models;


public class Product{
    private Integer id;
    private String name;
    private String category;
    private String description;
    private String photo;
    private Integer price_cents;
    private Integer stock;
    private String status;

    public Product() {}

    public Product(Integer id, String name, String category, String description, String photo, Integer price_cents, Integer stock, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.photo = photo;
        this.price_cents = price_cents;
        this.stock = stock;
        this.status = status;
    }

    public Integer getId(){
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

    public Integer getPrice_cents(){
        return this.price_cents;
    }

    public Integer getStock(){
        return this.stock;
    }

    public String getStatus(){
        return this.status;
    }

    public void setId(Integer id){
        this.id = id;
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

    public void setPrice(Integer price_cents){
        this.price_cents = price_cents;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public String setStatus(String status){
        this.status = status;
        return status;
    }

    public String toString(){
        return "Product(id=" + id + ", name=" + name + ", category=" + category + ", description=" + description + ", photo=" + photo + ", price_cents=" + price_cents + ", stock=" + stock + ", status=" + status + ")";
    }
}