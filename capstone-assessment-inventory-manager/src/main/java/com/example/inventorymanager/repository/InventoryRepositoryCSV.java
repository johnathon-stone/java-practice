package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.PerishableProduct;
import com.example.inventorymanager.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class InventoryRepositoryCSV implements InventoryRepository {

    private final Map<String, Product> inventory = new HashMap<>();

    @Value("data/inventory.csv")
    private String filename;

    @PostConstruct
    public void init() {
        loadFromCSV();
    }


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

        if (newProduct.getProductQuantity() < 0)
            throw new IllegalArgumentException("Product quantity cannot be negative");

        if (newProduct.getProductPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Product price cannot be zero or less than zero");
        }

        if (newProduct instanceof PerishableProduct perishable && perishable.isExpired()) {
            throw new IllegalArgumentException("Product is expired.");
        }


        if (isUniqueName(newProduct)) {
            inventory.put(newProduct.getProductID(), newProduct);
            saveToCSV();
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
            throw new IllegalArgumentException("Product does not exist");
        }
        inventory.put(productID, updatedProduct);
        saveToCSV();
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

    // Accepts a Product then uses one compares it
    @Override
    public boolean isUniqueName(Product newProduct) {
        for (Product product : inventory.values()) {
            if (product.getProductName().equalsIgnoreCase(newProduct.getProductName())
                    && !product.getProductID().equals(newProduct.getProductID())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Map<String, Product> getProducts() {
        return inventory;
    }

    // Attempts to initiate writing inventory data to file and catches a runtime exception
    private void saveToCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Product product : inventory.values()) {
                String base = String.format("%s,%s,%d,%.2f%n",
                        product.getProductID(),
                        product.getProductName(),
                        product.getProductQuantity(),
                        product.getProductPrice());

                if (product instanceof PerishableProduct perishable) {
                    base += "," + perishable.getExpiryDate();
                }

                pw.println(base);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving to file: " + filename, e);
        }
    }

    // Checks if a file exists then reads each line into the inventory
    private void loadFromCSV() {
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                String productID = parts[0];
                String productName = parts[1];
                int productQuantity = Integer.parseInt(parts[2]);
                BigDecimal productPrice = new BigDecimal(parts[3]);

                Product product;

                if (parts.length == 5) {
                    LocalDate expiryDate = LocalDate.parse(parts[4]);
                    product = new PerishableProduct(productID, productName, productQuantity, productPrice, expiryDate);
                } else {
                    product = new Product(productID, productName, productQuantity, productPrice);
                }
                inventory.put(productID, product);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading from file: " + filename, e);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error loading number from file: " + filename, e);
        }
    }
}
