package com.SpartanSmallBusinessManager.customer_crud_api.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Business.Business;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    private String gradeLevel;

    public Customer() {}

    public Customer(int customerId, String name, String username, String password, String email, String gradeLevel) {
        this.customerId = customerId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gradeLevel = gradeLevel;

    }

    public Customer(String name, String username, String password, String email, String gradeLevel) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }
    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }





}
