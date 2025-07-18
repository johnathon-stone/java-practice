package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.PerishableProduct;
import com.example.inventorymanager.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class InventoryRepositoryInMemory implements InventoryRepository {

    private final Map<String, Product> inventory = new HashMap<>();

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(inventory.values());
    }

    @Override
    public void addProductToInventory(Product newProduct) {
        if (newProduct == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (newProduct.getProductID() == null || newProduct.getProductID().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }

        if (newProduct.getProductName() == null || newProduct.getProductName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        if (newProduct.getProductQuantity() < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative");
        }

        if (newProduct.getProductPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product price cannot be zero or less than zero");
        }

        if (newProduct instanceof PerishableProduct perishable && perishable.isExpired()) {
            throw new IllegalArgumentException("Product is expired.");
        }

        if (isUniqueName(newProduct)) {
            inventory.put(newProduct.getProductID(), newProduct);
        }
    }

    @Override
    public void removeProductFromInventory(String productID) {
        if (productID == null || productID.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID can't be null or empty");
        }
        if (!inventory.containsKey(productID)) {
            throw new IllegalArgumentException("Product ID does not exist");
        }
        inventory.remove(productID);
    }

    @Override
    public void updateProductInInventory(Product updatedProduct) {
        if (updatedProduct == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (updatedProduct instanceof PerishableProduct perishable && perishable.isExpired()) {
            throw new IllegalArgumentException("Product is expired.");
        }

        String productID = updatedProduct.getProductID();

        if (!inventory.containsKey(productID)) {
            throw new IllegalArgumentException("Item does not exist");
        }
        inventory.put(productID, updatedProduct);
    }

    @Override
    public Product getByID(String productID) {
        if (productID == null || productID.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return inventory.get(productID);
    }

    @Override
    public Product getByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        return inventory.values().stream()
                .filter(obj -> Objects.equals(obj.getProductName(), productName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isNotUniqueID(String productID) {
        return inventory.containsKey(productID);
    }

    @Override
    public boolean isUniqueName(Product newProduct) {
        for (Product product : inventory.values()) {
            if (product.getProductName().equalsIgnoreCase(newProduct.getProductName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Map<String, Product> getProducts() {
        return inventory;
    }
}
