package com.csc340.spartan_manager.administration_portal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers("/user/login", "/user/register", "/error").permitAll()  // Allow everyone to access /login
                                .anyRequest().authenticated()  // All other requests require authentication
                )
                .csrf(csrf -> csrf.disable())  // Disables CSRF for testing purposes
                .formLogin(form -> form
                        .loginProcessingUrl("/user/login") // <-- This is the endpoint JS should POST to
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")  // URL to log out
                                .logoutSuccessUrl("/login?logout")  // Redirect to login after logout
                                .permitAll()
                );

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
