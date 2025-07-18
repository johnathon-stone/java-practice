package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.Product;

import java.util.List;
import java.util.Map;

public interface InventoryRepository {
    List<Product> getAll();

    void addProductToInventory(Product newProduct);

    void removeProductFromInventory(String productID);

    void updateProductInInventory(Product item);

    Product getByID(String productID);

    Product getByName(String productName);

    boolean isNotUniqueID(String productID);

    boolean isUniqueName(Product newProduct);

    Map<String, Product> getProducts();
}
