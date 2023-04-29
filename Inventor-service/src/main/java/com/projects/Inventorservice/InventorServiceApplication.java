package com.projects.Inventorservice;

import com.projects.Inventorservice.entity.Inventory;
import com.projects.Inventorservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory inventory= new Inventory();
			inventory.setSkuCode("Iphone_13");
			inventory.setQuantity(100);

			Inventory inventory1= new Inventory();
			inventory.setSkuCode("Iphone_13 red");
			inventory.setQuantity(59);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
