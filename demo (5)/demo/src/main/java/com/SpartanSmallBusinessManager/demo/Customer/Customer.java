package com.SpartanSmallBusinessManager.demo.Customer;

import com.SpartanSmallBusinessManager.demo.Review.Review;
import com.SpartanSmallBusinessManager.demo.Subscription.Subscription;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean subscribed;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();


    public Customer(int customerId, String firstName, String last_name, String username, String password, String email, List<Review> reviews) {
        this.customerId = customerId;
        this.first_name = firstName;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.reviews = reviews;
    }

    public Customer(String firstName, String last_name, String username, String password, String email, boolean subscribed) {
        this.first_name = firstName;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.subscribed = false;

    }

    public Customer(String username, String password, String email, boolean) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.subscribed = false;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
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


    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public boolean isSubscribed() {
        return subscribed;
    }
    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId= " +
                customerId +
                ", first_name= " +
                first_name +
                ", last_name= " +
                last_name +
                ", username= " +
                username +
                ", password= " +
                password +
                ", email= " +
                email +

                ", reviews= " +
                reviews +
                ", subscribed= " +
                subscribed +
                "}";

    }














}
