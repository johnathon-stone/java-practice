package org.example.utilities;

import org.example.model.Item;
import java.util.List;
import java.util.Scanner;

public class Utilities {
    Scanner input = new Scanner(System.in);

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getString(String prompt) {
        while (true) {
            displayMessage(prompt);
            String userInputSTR = input.nextLine();
            if (checkString(userInputSTR)){
                displayMessage("Input can't be empty, try again.");
            } else return userInputSTR;
        }
    }

    public boolean checkString(String string) {
        return string.trim().isEmpty();
    }

    public int getInt(String prompt) {
        while (true) {
            displayMessage(prompt);
            try {
                int userInputInt = Integer.parseInt(input.nextLine());
                if (!checkInteger(userInputInt)) {
                    displayMessage("Invalid input, enter a integer greater than 0. Please try again.");
                } else return userInputInt;
            } catch (NumberFormatException e) {
                displayMessage("Invalid input, enter a integer. Please try again.");
            }
        }
    }

    //clean naming up
    public boolean checkInteger(Integer integer) {
        return integer > 0;
    }

    public void displayOrderList(List<Item> shoppingCart) {
        if (shoppingCart.isEmpty()) {
            displayMessage("There is nothing on your order.");
            return;
        }

// Adjust format for efficiency
        displayMessage("=============Current Order=============");
        for (int i = 0; i < shoppingCart.size(); i++) {
            String line = String.format("%d. %s, Qty: %d, cost: $%.2f/ea",
                    i + 1,
                    shoppingCart.get(i).getName(),
                    shoppingCart.get(i).getQuantity(),
                    shoppingCart.get(i).getCost());
            displayMessage(line);
        }
    }
}
