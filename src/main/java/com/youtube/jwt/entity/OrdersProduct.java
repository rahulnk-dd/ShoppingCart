package com.youtube.jwt.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrdersProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private int quantities;
    private int productCost;
    private int sellingPrice;
    private String productImage;

    private String brand;

    private String category;

    public OrdersProduct() {
    }

    public OrdersProduct(String productName, int quantities, int productCost, int sellingPrice, String productImage, String brand, String category) {
        this.productName = productName;
        this.quantities = quantities;
        this.productCost = productCost;
        this.sellingPrice = sellingPrice;
        this.productImage = productImage;
        this.brand = brand;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
