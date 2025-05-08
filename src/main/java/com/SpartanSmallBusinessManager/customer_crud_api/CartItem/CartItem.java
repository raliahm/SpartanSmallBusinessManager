package com.SpartanSmallBusinessManager.customer_crud_api.CartItem;

import com.SpartanSmallBusinessManager.customer_crud_api.Cart.Cart;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int quantity;

    public CartItem() {}

    public CartItem(int cartItemId, Cart cart, Product product, int quantity) {
        this.cartItemId = cartItemId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() { return cartItemId; }
    public void setId(int id) { this.cartItemId = cartItemId; }

    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
