package org.example;

import org.example.utilities.Utilities;
import org.example.command.*;
import org.example.shoppingcart.OrderServices;

public class App {

    public static void main(String[] args ) {
        Utilities utilities = new Utilities();
        OrderServices services = new OrderServices(utilities);
        AddItem addItem = new AddItem();
        Checkout checkout = new Checkout();
        DisplayOrder displayOrder = new DisplayOrder();
        RemoveItem removeItem = new RemoveItem();

        utilities.displayMessage("Welcome to Good Burger, home of the Good Burger!");
        while (true) {
            utilities.displayMessage("===============Main Menu===============\n1. Display Order\n 2. Remove an Item\n 3. Add an Item\n 4. Checkout\n 5. Exit");
            int choice = utilities.getInt("Can I take your order? ");

            switch (choice) {
                case 1 -> displayOrder.execute(utilities, services);
                case 2 -> removeItem.execute(utilities, services);
                case 3 -> addItem.execute(utilities, services);
                case 4 -> checkout.execute(utilities, services);
                case 5 -> {
                    utilities.displayMessage("Thank you for coming to Good Burger!");
                    System.exit(0);
                }
                default -> utilities.displayMessage("Invalid input please try again.(1-5)");
            }
        }
    }
}
