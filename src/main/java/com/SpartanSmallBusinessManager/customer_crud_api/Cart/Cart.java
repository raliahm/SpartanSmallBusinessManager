package com.SpartanSmallBusinessManager.customer_crud_api.Cart;

import com.SpartanSmallBusinessManager.customer_crud_api.CartItem.CartItem;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int cartId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double total;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartItem> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true, nullable = false)
    private Customer customer;


    @Transient
    private Set<Product> products = new HashSet<>();

    public Cart(){}

    public Cart(int cartId, int quantity, double total, Set<Product> products) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
        this.products = products;
    }
    public Cart(int quantity, double price, double total, Customer customer, Set<Product> products, List<CartItem> items) {
        this.quantity = quantity;
        this.total = total;
        this.customer = customer;
        this.products = products;
        this.items = items;
    }
    public Cart(int cartId, int quantity, double total) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
    }
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<CartItem> getItems() {
        return items;
    }
    public void setItems(List<CartItem> items) {
        this.items = items;
    }

}
