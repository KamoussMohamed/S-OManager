package com.example.jeeproject;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.jeeproject.dao.entities.Customer;
import com.example.jeeproject.dao.entities.Order;
import com.example.jeeproject.dao.entities.Product;
import com.example.jeeproject.services.CustomerManager;
import com.example.jeeproject.services.OrderManager;
import com.example.jeeproject.services.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableTransactionManagement
public class JeeProjectApplication implements CommandLineRunner {

	@Autowired
	private CustomerManager customerManager;
	@Autowired
	private ProductManager productManager;
	@Autowired
	private OrderManager orderManager;

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

			Product product2 = new Product();
			product2.setProductName("BMW");
			product2.setQuantity(2);
			product2.setProductUnitPrice(500000);
			productManager.addProduct(product2);

			Product product3 = new Product();
			product3.setProductName("Audi");
			product3.setQuantity(2);
			product3.setProductUnitPrice(600000);
			productManager.addProduct(product3);

			Order order = new Order();
			order.setCustomer(customer);
			order.setOrderDescription("order 1");
			order.setProducts(List.of(product, product2, product2, product3));
			orderManager.addOrder(order);

			Order order2 = new Order();
			order2.setCustomer(customer);
			order2.setOrderDescription("order 2");
			order2.setProducts(List.of(product, product2));
			orderManager.addOrder(order2);

		};
	}
}
