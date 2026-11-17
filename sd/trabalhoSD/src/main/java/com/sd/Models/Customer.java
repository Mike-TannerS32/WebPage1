package com.sd.Models;

public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public int setId(int id){
        this.id = id;
        return id;
    }

    public String setName(String name){
        this.name = name;
        return name;
    }

    public String setEmail(String email){
        this.email = email;
        return email;
    }

    public String toString(){
        return "Customer(id=" + id + ", name=" + name + ", email=" + email + ")";
    }
}