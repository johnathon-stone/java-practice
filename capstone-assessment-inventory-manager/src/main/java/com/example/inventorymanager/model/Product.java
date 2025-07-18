package com.example.inventorymanager.model;

import java.math.BigDecimal;

public class Product {
    private String productID;
    private String productName;
    private int productQuantity;
    private BigDecimal productPrice;

    public Product(String productID, String productName, int productQuantity, BigDecimal productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(int productQuantity) {
        if (productQuantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be less than 0");
        }
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(BigDecimal productPrice) {
        if (productPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The product price can't be negative.");
        }
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return String.format("Product ID: %s, Product Name: %s QTY: %d Price/item: $%.2f",
                this.productID,
                this.productName,
                this.productQuantity,
                this.productPrice);
    }
}
