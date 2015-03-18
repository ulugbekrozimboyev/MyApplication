package com.example.ulugbek.myapplication.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulugbek on 05.03.2015.
 */
public class Category {
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProduct(){
        List<Product> products = new ArrayList<Product>();
        return products;
    }
}
