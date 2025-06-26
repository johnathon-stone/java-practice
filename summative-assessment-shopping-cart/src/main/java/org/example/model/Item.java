package org.example.model;

import java.util.Formatter;

public class Item {
    private final String name;
    private int quantity;
    private final double cost;

    public Item(String name, double cost, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        try (Formatter formatter = new Formatter(stringBuilder)){
            formatter.format("%-15s   Cost: $%.2f", name, cost);
        }
        return stringBuilder.toString();
    }

    public boolean isValid() {
        return cost > 0 && !name.trim().isEmpty();
    }
}
