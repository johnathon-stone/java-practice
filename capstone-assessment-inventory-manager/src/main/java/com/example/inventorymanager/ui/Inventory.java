package com.example.inventorymanager.ui;

import com.example.inventorymanager.model.PerishableProduct;
import com.example.inventorymanager.model.Product;
import com.example.inventorymanager.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Inventory {

    private final InventoryIO inventoryIO;
    private final InventoryService inventoryService;

    @Autowired
    public Inventory(InventoryIO inventoryIO, InventoryService inventoryService) {
        this.inventoryIO = inventoryIO;
        this.inventoryService = inventoryService;
    }

    public void run() throws InterruptedException {
        inventoryIO.displayWelcomeMessage();

        boolean running = true;
        while (running) {
            int choice = inventoryIO.displayMenuAndGetChoice();

            switch (choice) {
                case 1:
                    manageAddProduct();
                    break;
                case 2:
                    manageViewProducts();
                    break;
                case 3:
                    manageSearchProduct();
                    break;
                case 4:
                    manageUpdateProduct();
                    break;
                case 5:
                    manageDeleteProduct();
                    break;
                case 6:
                    manageSaveInventoryToCSV();
                    break;
                case 7:
                    running = manageExitProgram();
                    break;
                default:
                    inventoryIO.displayError("Invalid choice. Please try again.");
            }
        }
    }

    private void manageAddProduct() {
        inventoryIO.displayHeader("Add Product to Inventory");

        try {
            Product product = inventoryIO.getProductData();

            if (product == null) {
                throw new IllegalArgumentException("Item cannot be null.");
            }

            Product existingItem = inventoryService.getProduct(product.getProductID(), 1);

            int response = inventoryService.addProduct(product);

            switch (response) {
                case 1:
                    inventoryIO.displayFailure("Product already exists with ID: " + product.getProductID());
                    break;
                case 2:
                    inventoryIO.displayFailure("Product already exists with name: " + product.getProductName());
                    break;
                case 3:
                    if (product instanceof PerishableProduct perishable) {
                        inventoryIO.displayFailure("Product is already past its expiration date: " + perishable.getExpiryDate());
                    } else {
                        inventoryIO.displayFailure("Product is invalid.");
                    }
                    break;
                case 4:
                    inventoryIO.displaySuccess("Product has been added to inventory.");
                    break;
                default:
                    inventoryIO.displayError("Invalid response from server.");
            }
        } catch (Exception e) {
            inventoryIO.displayError("Failed due to: " + e.getMessage());
        }
    }

    private void manageViewProducts() {
        inventoryIO.displayHeader("Viewing All Products");

        List<Product> allItems = inventoryService.getProducts();
        if (allItems == null) {
            inventoryIO.displayError("No items found.");
            return;
        }
        inventoryIO.displayProducts(allItems);
    }

    private Product searchForProduct(String productInfo, int choice) {
        if (productInfo == null) return null;//possibly excessive measures

        Product product = inventoryService.getProduct(productInfo, choice);
        if (product == null) {
            inventoryIO.displayError("No product with: " + productInfo + " found.");
            return null;
        }
        return product;
    }

    private void manageSearchProduct() {
        Product product;
        int choice = inventoryIO.displaySearchMenu();

        switch (choice) {
            case 1:
                inventoryIO.displayHeader("Search for Product by ID");
                product = searchForProduct(inventoryIO.getStringInput("Enter the Product ID: "), choice);
                inventoryIO.displayProduct(product);
                break;
            case 2:
                inventoryIO.displayHeader("Search for Product by Name");
                product = searchForProduct(inventoryIO.getStringInput("Enter the Product Name: "), choice);
                inventoryIO.displayProduct(product);
                break;
            default:
                inventoryIO.displayError("Cancelling search.");
        }
    }

    private void manageUpdateProduct() throws InterruptedException {
        inventoryIO.displayHeader("Update Product");
        inventoryIO.displayProducts(inventoryService.getProducts());
        Product updatedProduct = inventoryIO.getProductData();
        inventoryIO.displayProduct(updatedProduct);
        String choice = inventoryIO.getStringInput("Are you sure you want to update the item? (Y/N) ");
        if (choice.equalsIgnoreCase("Y")) {
            inventoryService.updateProduct(updatedProduct);
        }
    }

    private void manageDeleteProduct() {
        inventoryIO.displayHeader("Delete Product");
        inventoryService.removeProduct(inventoryIO.getStringInput("Enter the Product ID: "));
    }

    private void manageSaveInventoryToCSV() {
        inventoryIO.displayHeader("Save Inventory to CSV");
        inventoryService.saveInventoryToCSV();
    }

    private boolean manageExitProgram() {
        String choice = inventoryIO.getExitChoice();
        if (choice.equalsIgnoreCase("Y")) {
            inventoryIO.displayGoodbye();
            return false;
        }
        return true;
    }
}
