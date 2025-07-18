package com.example.inventorymanager.config;

import com.example.inventorymanager.repository.InventoryRepository;
import com.example.inventorymanager.repository.InventoryRepositoryCSV;
import com.example.inventorymanager.repository.InventoryRepositoryInMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {

    @Value("${inventory.repository.type:csv}")
    private String repositoryType;


    @Bean
    public InventoryRepository inventoryRepository() {
        switch (repositoryType.toLowerCase()) {
            case "csv":
                return new InventoryRepositoryCSV();
            case "memory":
                return new InventoryRepositoryInMemory();
            default:
                throw new IllegalArgumentException("Invalid repository type: " + repositoryType);
        }
    }
}
