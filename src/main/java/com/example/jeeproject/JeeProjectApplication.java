package com.example.jeeproject;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.jeeproject.dao.entities.*;
import com.example.jeeproject.services.*;
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
	private AppUserManager appUserManager;
	@Autowired
	private AppAdminManager appAdminManager;

	public static void main(String[] args) {
		SpringApplication.run(JeeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			AppAdmin appAdmin = new AppAdmin();
			appAdmin.setUsername("Admin");
			appAdmin.setPassword("Admin");
			appAdmin.setEmail("admin@admin.com");
			appAdminManager.addAppAdmin(appAdmin);

			AppUser appUser = new AppUser();
			appUser.setUsername("User");
			appUser.setPassword("User");
			appUser.setEmail("user@user.com");
			appUser.setInAppRole("Normal User");
			appUserManager.addAppUser(appUser);
		};
	}
}
