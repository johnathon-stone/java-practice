package com.example.inventorymanager.ui;

import com.example.inventorymanager.model.PerishableProduct;
import com.example.inventorymanager.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class InventoryIO {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    private final Scanner scanner;

    public InventoryIO() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("||=========================================================================================||");
        displayHeader("Welcome to Inventory Manager");
    }

    public int displayMenuAndGetChoice() {
        displayHeader("Main Menu");
        System.out.println("|| 1. Add Product                                                                          ||");
        System.out.println("|| 2. View Products                                                                        ||");
        System.out.println("|| 3. Search Product                                                                       ||");
        System.out.println("|| 4. Update Product                                                                       ||");
        System.out.println("|| 5. Delete Product                                                                       ||");
        System.out.println("|| 6. Save Inventory to File                                                               ||");
        System.out.println("|| 7. Quit                                                                                 ||");
        System.out.println("||=========================================================================================||");

        return getMenuIntegerInput("Select an option (1-7): ");
    }

    public String stringAddPadding(String originalString, int targetLength, String paddingString, String side) {
        if (originalString == null) {
            originalString = "";
        }

        int originalLength = originalString.length();

        if (originalLength >= targetLength) {
            return originalString.substring(0, targetLength);
        }

        int totalPadLength = targetLength - originalLength;
        StringBuilder leftPad = new StringBuilder();
        StringBuilder rightPad = new StringBuilder();

        while (leftPad.length() + rightPad.length() < totalPadLength) {
            if (side.equals("l") || side.equals("b")) {
                if (leftPad.length() < (side.equals("b") ? totalPadLength / 2 : totalPadLength)) {
                    leftPad.append(paddingString);
                }
            }

            if (side.equals("r") || side.equals("b")) {
                if (rightPad.length() < (side.equals("b") ? totalPadLength - totalPadLength / 2 : totalPadLength)) {
                    rightPad.append(paddingString);
                }
            }
        }

        if (leftPad.length() > totalPadLength) {
            leftPad.setLength(totalPadLength);
        }

        if (rightPad.length() > totalPadLength) {
            rightPad.setLength(totalPadLength);
        }

        return leftPad + originalString + rightPad;
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            displayError(RED + "Please enter a valid input" + RESET);
            return getStringInput(prompt);
        }
        return input;
    }

    public Integer getMenuIntegerInput(String prompt) {
        String input = getStringInput(prompt);

        try {
            int value = Integer.parseInt(input);
            if (value < 1 || value > 7) {
                displayError(RED + "Please enter a valid number (1-7)" + RESET);
                return getIntegerInput(prompt);
            }
            return value;
        } catch (NumberFormatException e) {
            displayError(RED + "Please enter a valid number (1-7)" + RESET);
            return getIntegerInput(prompt);
        }
    }

    public Integer getIntegerInput(String prompt) {
        String input = getStringInput(prompt);

        try {
            int value = Integer.parseInt(input);
            if (value < 1) {
                displayError("Please enter a positive number.");
                return getIntegerInput(prompt);
            }
            return value;
        } catch (NumberFormatException e) {
            displayError("Please enter a valid number.");
            return getIntegerInput(prompt);
        }
    }

    public BigDecimal getBigDecimalInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            displayError("Input can't be empty. Please enter a valid number.");
            return getBigDecimalInput(prompt);
        }

        try {
            BigDecimal price = new BigDecimal(input);
            if (price.compareTo(BigDecimal.ZERO) <= 0) {
                displayError("Please enter a positive number.");
                return getBigDecimalInput(prompt);
            }
            return price;
        } catch (NumberFormatException e) {
            displayError("Please enter a valid price (e.g., 9.99).");
            return getBigDecimalInput(prompt);
        }
    }

    public boolean getYesOrNoInput(String prompt) {
        String input = getStringInput(prompt);
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }

    public void displayError(String s) {
        System.out.println(RED + "‼️ Error: " + s + RESET);
    }

    public void displayGoodbye() {
        System.out.println("👋Goodbye!");
    }

    public void displayHeader(String header) {
        String paddedHeader = stringAddPadding(header, 89, "=", "b");
        System.out.println("||" + paddedHeader + "||");
    }

    public void displaySuccess(String message) {
        System.out.println(GREEN + "✅ Success: " + message + RESET);
    }

    public void displayFailure(String message) {
        System.out.println(RED + "❎ Failure: " + message + RESET);
    }

    public void displayProducts(List<Product> allProducts) {
        if (allProducts == null || allProducts.isEmpty()) {
            System.out.println("No items found");
            return;
        }

        System.out.printf("||%-18s %-30s %8s  %12s  %15s||%n", "ID", "NAME", "QUANTITY", "PRICE", "EXPIRATION");
        System.out.println("||=========================================================================================||");

        for (Product product : allProducts) {
            String productID = stringAddPadding(product.getProductID(), 4, " ", "r");
            String productName = stringAddPadding(product.getProductName(), 10, " ", "r");
            String productQuantity = stringAddPadding(String.valueOf(product.getProductQuantity()), 3, " ", "l");
            String productPrice = stringAddPadding(String.valueOf(product.getProductPrice()), 6, " ", "l");
            String expiry = "-";

            if (product instanceof PerishableProduct perishable) {
                expiry = stringAddPadding(perishable.getExpiryDate().toString(), 4, " ", "l");
            }

            System.out.printf("||%-18s %-20s %18s        $%-15s %-6s||%n",
                    productID,
                    productName,
                    productQuantity,
                    productPrice,
                    expiry);
        }
        System.out.println("||=========================================================================================||");
    }

    public void displayProduct(Product product) {
        String productID = stringAddPadding(product.getProductID(), 76, " ", "l");
        String productName = stringAddPadding(product.getProductName(), 74, " ", "l");
        String productQuantity = stringAddPadding(String.valueOf(product.getProductQuantity()), 70, " ", "l");
        String productPrice = stringAddPadding(String.valueOf(product.getProductPrice()), 6, " ", "l");

        System.out.println("||=========================================================================================||");
        System.out.printf("|| Product ID: %s||\n", productID);
        System.out.printf("|| Product Name: %s||\n", productName);
        System.out.printf("|| Product Quantity: %s||\n", productQuantity);
        System.out.printf("|| Product Price:                                                                   $%s||\n", productPrice);

        if (product instanceof PerishableProduct perishable) {
            String expiry = stringAddPadding(perishable.getExpiryDate().toString(), 75, " ", "l");
            System.out.printf("|| Expiry Date: %s||\n", expiry);
        }

        System.out.println("||=========================================================================================||");
    }

    public Product getProductData() throws InterruptedException {
        Thread.sleep(1000);
        String productID = getStringInput("Enter the Product ID: ");
        if (productID == null) return null;

        Thread.sleep(1000);
        String productName = getStringInput("Enter the Product Name: ");
        if (productName == null) return null;

        Thread.sleep(1000);
        Integer productQuantity = getIntegerInput("Enter the Product Quantity: ");
        if (productQuantity == null) return null;

        Thread.sleep(1000);
        BigDecimal productPrice = getBigDecimalInput("Enter the Product Price: ");
        if (productPrice == null) return null;

        boolean isPerishable = getYesOrNoInput("Is this product perishable? (Y/N): ");

        if (isPerishable) {
            LocalDate expiryDate = null;
            while (expiryDate == null) {
                try {
                    String expiryInput = getStringInput("Enter the Expiry Date (yyyy-MM-dd): ");
                    expiryDate = LocalDate.parse(expiryInput);
                } catch (Exception e) {
                    displayError("Invalid Expiry Date. Please enter date in yyyy-mm-dd format.");
                }
            }
            return new PerishableProduct(productID, productName, productQuantity, productPrice, expiryDate);
        }
        return new Product(productID, productName, productQuantity, productPrice);
    }

    public String getExitChoice() {
        displayHeader("Exit Program");
        return getStringInput("Are you sure you want to exit? (Y/N): ");
    }

    public int displaySearchMenu() {
        System.out.println("||========================================================================||");
        System.out.println("|| 1. Search by Product ID                                                ||");
        System.out.println("|| 2. Search by Name                                                      ||");
        System.out.println("|| 3. Exit to Main Menu                                                   ||");
        System.out.println("||========================================================================||");

        return getMenuIntegerInput("Select an option (1-3): ");
    }
}
