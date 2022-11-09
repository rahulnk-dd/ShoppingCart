package com.youtube.jwt.dto;

import com.youtube.jwt.entity.Product;

import javax.persistence.ManyToMany;
import java.util.List;

public class ShoppindDTO {

    private String userName;

    @ManyToMany()
    private List<Product> products;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppindDTO{" +
                "userName='" + userName + '\'' +
                ", products=" + products +
                '}';
    }
}
