package com.example.jeeproject;

import com.example.jeeproject.dao.entities.Customer;
import com.example.jeeproject.dao.entities.Product;
import com.example.jeeproject.services.CustomerManager;
import com.example.jeeproject.services.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JeeProjectApplication implements CommandLineRunner {

	@Autowired
	private CustomerManager customerManager;
	@Autowired
	private ProductManager productManager;

	public static void main(String[] args) {
		SpringApplication.run(JeeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			Customer customer = new Customer();
			customer.setName("Mohamed");
			customer.setEmail("mohamed@gmail.com");
			customer.setAddress("Rue 1 nomRue nomVille");
			customerManager.createCustomer(customer);

			Product product = new Product();
			product.setProductName("Ferrari");
			product.setQuantity(2);
			product.setProductUnitPrice(1000000);
			productManager.addProduct(product);

		};
	}
}
