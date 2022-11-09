package com.youtube.jwt.dto;

import com.youtube.jwt.entity.Product;

import java.util.List;

public class ProductDTO {

    private List<Product> products;

    private List brand;

    private List category;

    public ProductDTO(List<Product> products, List brand, List category) {
        this.products = products;
        this.brand = brand;
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List getBrand() {
        return brand;
    }

    public void setBrand(List brand) {
        this.brand = brand;
    }

    public List getCategory() {
        return category;
    }

    public void setCategory(List category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "products=" + products +
                ", brand=" + brand +
                ", category=" + category +
                '}';
    }
}
