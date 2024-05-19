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


	public static void main(String[] args) {
		SpringApplication.run(JeeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public CommandLineRunner init() {
		return args -> {

		};
	}
}
