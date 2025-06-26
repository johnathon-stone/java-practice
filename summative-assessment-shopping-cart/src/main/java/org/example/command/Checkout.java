package org.example.command;

import org.example.shoppingcart.OrderServices;
import org.example.utilities.Utilities;

public class Checkout implements Command{

    @Override
    public void execute(Utilities utilities, OrderServices services) {
        DisplayOrder displayOrder = new DisplayOrder();

        displayOrder.execute(utilities, services);
        String choice = utilities.getString("Would you like to checkout? (y/n)");
        if (choice.equalsIgnoreCase("y")) {
            services.getTotal();
        }
    }
}
