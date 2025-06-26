package org.example.command;

import org.example.shoppingcart.OrderServices;
import org.example.utilities.Utilities;

public class RemoveItem implements Command{

    @Override
    public void execute(Utilities utilities, OrderServices services) {
        boolean isRemoved = false;
        while (!isRemoved) {
            services.getCustomerOrder();
            String userChoice = utilities.getString("What item would you like to remove? ");
            int itemQuantity = utilities.getInt("How many would you like to remove: ");
            isRemoved = services.removeItem(userChoice, itemQuantity);
        }
    }
}
