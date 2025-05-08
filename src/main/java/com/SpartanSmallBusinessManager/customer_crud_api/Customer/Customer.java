package com.SpartanSmallBusinessManager.customer_crud_api.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Cart.Cart;
import jakarta.persistence.*;



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


    private String password;


    private String confirmPassword;

    @Column(nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    private String gradeLevel;

    public Customer() {}

    public Customer(int customerId, String name, String username, String password, String email, String gradeLevel, Cart cart) {
        this.customerId = customerId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gradeLevel = gradeLevel;
        this.cart = cart;

    }

    public Customer(String name, String username, String password, String email, String gradeLevel, Cart cart) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gradeLevel = gradeLevel;
        this.cart = cart;
    }
    public Customer(String name, String username, String password, String confirmPassword, String email, String gradeLevel) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    public Customer(String name, String username, String email, String gradeLevel) {
        this.name = name;
        this.username = username;
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
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }





}
