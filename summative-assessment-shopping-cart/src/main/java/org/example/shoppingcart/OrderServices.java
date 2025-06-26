package org.example.shoppingcart;

import org.example.utilities.Utilities;
import org.example.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class OrderServices {
    private final Utilities utilities;

    private final HashMap<String, Item> customerOrder = new HashMap<>();

    public OrderServices(Utilities utilities) {
        this.utilities = utilities;
    }

    public void addItem(Item item) {
        if (item.isValid()) {
            //improve naming
            if (!checkForItem(item)) {
                customerOrder.put(item.getName(), item);
            } else {
                Item originalItem = customerOrder.get(item.getName());
                originalItem.addQuantity(item.getQuantity());
            }
        }
    }

    public boolean removeItem(String itemName, int quantity) {
        if (customerOrder.containsKey(itemName)) {
            Item existing = customerOrder.get(itemName);

            if (existing.getQuantity() > quantity) {
                existing.addQuantity(-quantity);
                return true;
            }
            if (existing.getQuantity() == quantity) {
                customerOrder.remove(itemName);
                return true;
            }
        }
        utilities.displayMessage("You can't remove more than you ordered.");
        return false;
    }

    public boolean checkForItem(Item item) {
        return customerOrder.containsKey(item.getName());
    }

    public Item getItemByName(String name) {
        return customerOrder.get(name);
    }

    public int getOrderSize() {
        return customerOrder.size();
    }

    public int getItemQuantity(String itemName) {
        if (customerOrder.containsKey(itemName)) {
            Item item = customerOrder.get(itemName);
            return item.getQuantity();
        }
        return -1;
    }

    public List<Item> getCustomerOrder() {
        ArrayList<Item> items = new ArrayList<>();
        for (Item item: customerOrder.values()) {
            items.add(item);
        }
        return items;
    }

    public void emptyOrder() {
        if (!checkForEmpty()) {
            customerOrder.clear();
            utilities.displayMessage("Your order is now complete.");
        }
    }

    public boolean checkForEmpty() {
        return customerOrder.isEmpty();
    }

    //separate method responsibilities better
    public void getTotal() {
        double total = 0.0;
        if (checkForEmpty()) {
            utilities.displayMessage("You have to order something first.");
            return;
        }
        utilities.displayMessage("===========Checkout Receipt===========");
        for (Map.Entry<String, Item> entry : customerOrder.entrySet()) {
            Item item = entry.getValue();
            total += item.getCost() * item.getQuantity();
            utilities.displayMessage(String.valueOf(item));
        }
        String checkout = String.format("--------------------------------------\nTotal Cost: $%.2f\n%s",
                total,
                "======================================");
        utilities.displayMessage(checkout);
        emptyOrder();
    }
}
