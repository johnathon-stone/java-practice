package org.example.shoppingcart;

import org.example.model.Item;
import java.util.ArrayList;
import org.example.utilities.Utilities;

public class MenuItems {
    private final ArrayList<Item> currentMenu;
    private final Utilities utilities = new Utilities();

    public MenuItems() {
        this.currentMenu = new ArrayList<>();
        addCurrentMenu();
    }

    private void addCurrentMenu() {
        currentMenu.add(new Item("Good Burger", 1.49, 0));
        currentMenu.add(new Item("Good Chickwich", 2.49, 0));
        currentMenu.add(new Item("Good Taco", 1.09, 0));
        currentMenu.add(new Item("Good Dogs", 2.99, 0));
        currentMenu.add(new Item("Good Fries", 0.79, 0));
        currentMenu.add(new Item("Good Cookies", 0.79, 0));
        currentMenu.add(new Item("Good Pickles", 0.49, 0));
        currentMenu.add(new Item("Good Beverage", 0.89, 0));
        currentMenu.add(new Item("Good Shake", 1.09, 0));
    }

    public void getCurrentMenu() {
        utilities.displayMessage("=========Good Burger Menu=========");
        for (int i = 0; i < currentMenu.size(); i++) {
            utilities.displayMessage("|" + (i + 1) + ". " + currentMenu.get(i) + "|");
        }
    }

    public String getName(int index) {
        return currentMenu.get(index - 1).getName();
    }

    public double getCost(int index) {
        return currentMenu.get(index - 1).getCost();
    }
}
