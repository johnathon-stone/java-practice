package com.example.inventorymanager.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class PerishableProduct extends Product {
    private LocalDate expiryDate;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PerishableProduct(String productID, String productName, int productQuantity, BigDecimal productPrice, LocalDate expiryDate) {
        super(productID, productName, productQuantity, productPrice);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Expiry Date: %s", expiryDate.format(formatter));
    }
}
