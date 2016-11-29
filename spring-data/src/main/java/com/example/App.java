package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bean.Customer;
import com.example.repositories.CustomerRepository;

@SpringBootApplication
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			LOGGER.info("Customers found with findAll():");
			LOGGER.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				LOGGER.info(customer.toString());
			}
			LOGGER.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			LOGGER.info("Customer found with findOne(1L):");
			LOGGER.info("--------------------------------");
			LOGGER.info(customer.toString());
			LOGGER.info("");

			// fetch customers by last name
			LOGGER.info("Customer found with findByLastName('Bauer'):");
			LOGGER.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				LOGGER.info(bauer.toString());
			}
			LOGGER.info("");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}
}
