package com.example.inventorymanager.service;

import com.example.inventorymanager.model.*;
import com.example.inventorymanager.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Put Item in inventory
    public int addProduct(Product newProduct) {
        String productID = newProduct.getProductID();

        if (inventoryRepository.isNotUniqueID(productID)) return 1;

        if (!inventoryRepository.isUniqueName(newProduct)) return 2;

        if (newProduct instanceof PerishableProduct perishable && perishable.isExpired()) return 3;

        inventoryRepository.addProductToInventory(newProduct);
        return 4;
    }

    // Update single Item in inventory
    public void updateProduct(Product updatedItem) {
        if (updatedItem == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        inventoryRepository.updateProductInInventory(updatedItem);
    }

    // Remove single Item from inventory using key(productID)
    public void removeProduct(String productID) {
        if (!inventoryRepository.isNotUniqueID(productID)) {
            throw new IllegalArgumentException("Product ID does not exist.");
        }
        inventoryRepository.removeProductFromInventory(productID);
    }

    // Single Item from inventory using key(productID)
    public Product getProduct(String productInfo, int choice) {
        if (choice == 1) {
            return inventoryRepository.getByID(productInfo);
        }
        return inventoryRepository.getByName(productInfo);
    }

    // All Items from inventory
    public List<Product> getProducts() {
        return inventoryRepository.getAll();
    }

    // Saves the Inventory to the inventory.csv
    public void saveInventoryToCSV() {
        List<Product> products = getProducts();
        for (Product product : products) {
            inventoryRepository.addProductToInventory(product);
        }
    }
}
