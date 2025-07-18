package com.example.inventorymanager;

import com.example.inventorymanager.ui.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner {

    private final Inventory inventory;

    public InventoryManagerApplication(Inventory inventory) {
        this.inventory = inventory;
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        inventory.run();
    }
}
