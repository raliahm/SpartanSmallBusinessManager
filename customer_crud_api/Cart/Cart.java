package com.SpartanSmallBusinessManager.customer_crud_api.Cart;

import jakarta.persistence.*;


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

    public Cart(){}

    public Cart(int cartId, int quantity, double total) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.total = total;
    }
    public Cart(int quantity, double price, double total) {
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
}
