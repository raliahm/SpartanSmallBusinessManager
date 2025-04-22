package com.csc340.spartan_manager.administration_portal.config;

import com.csc340.spartan_manager.administration_portal.Entity.UserEntity;
import com.csc340.spartan_manager.administration_portal.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    public CommandLineRunner createFirstUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        System.out.println("Creating first user");
        return args -> {
//            UserEntity user = new UserEntity();
//            user.setUsername("reba");
//            user.setPassword(passwordEncoder.encode("1234"));
//            user.setRoles(List.of("admin")); // or whatever your roles setup is
//            userRepository.save(user);
//            System.out.println("Admin user created!");

            if (userRepository.findByUsername("admin") == null) {
                UserEntity user = new UserEntity();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin123"));
                user.setRoles(List.of("ROLE_USER")); // or whatever your roles setup is
                userRepository.save(user);
                System.out.println("Admin user created!");
            }
        };
    }
}
