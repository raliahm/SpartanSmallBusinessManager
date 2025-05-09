package com.csc340.spartan_manager.administration_portal;

import com.csc340.spartan_manager.administration_portal.Entity.UserEntity;
import com.csc340.spartan_manager.administration_portal.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AdministrationPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministrationPortalApplication.class, args);
	}

}
