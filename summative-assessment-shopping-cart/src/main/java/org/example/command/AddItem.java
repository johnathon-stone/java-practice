package org.example.command;

import org.example.model.Item;
import org.example.shoppingcart.OrderServices;
import org.example.shoppingcart.MenuItems;
import org.example.utilities.Utilities;

public class AddItem implements Command{
    MenuItems menuItems = new MenuItems();

    @Override
    public void execute(Utilities utilities, OrderServices services) {

        menuItems.getCurrentMenu();
        int userChoice = utilities.getInt("What item would you like to add? ");
        if (userChoice > 9) {
            utilities.displayMessage("Invalid Item selection. Please try again. (1-9)");
            return;
        }
        int itemQuantity = utilities.getInt("How many would you like to add: ");
        Item toAdd = new Item(menuItems.getName(userChoice), menuItems.getCost(userChoice), itemQuantity);
        services.addItem(toAdd);

    }
}
