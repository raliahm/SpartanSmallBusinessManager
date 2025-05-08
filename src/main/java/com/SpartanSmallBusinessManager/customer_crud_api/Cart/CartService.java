package com.SpartanSmallBusinessManager.customer_crud_api.Cart;

import com.SpartanSmallBusinessManager.customer_crud_api.CartItem.CartItem;
import com.SpartanSmallBusinessManager.customer_crud_api.CartItem.CartItemRepository;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.CustomerRepository;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.Product;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(int cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    public void updateCart(Cart cart, int cartId) {
        Cart existing = getCartById(cartId);
        existing.setTotal(cart.getTotal());
        existing.setQuantity(cart.getQuantity());
        existing.setItems(cart.getItems());
        cartRepository.save(existing);
    }

    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }

    public void addProductToCart(int customerId, int productId, int quantity) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        Cart cart = customer.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer);
            cart.setItems(new ArrayList<>());
            cart.setQuantity(0);
            cart.setTotal(0.0);
            cartRepository.save(cart);
            customer.setCart(cart);
        }

        CartItem existingItem = cart.getItems().stream()
                .filter(i -> i.getProduct().getProductId() == productId)
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem(cart, product, quantity);
            cart.getItems().add(newItem);
        }

        recalculateCartTotals(cart);
        cartRepository.save(cart);
    }

    public void removeProductFromCart(int customerId, int productId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID"));

        Cart cart = customer.getCart();
        if (cart != null) {
            cart.getItems().removeIf(i -> i.getProduct().getProductId() == productId);
            recalculateCartTotals(cart);
            cartRepository.save(cart);
        }
    }

    public Cart getCartByCustomerId(int customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        return (customer != null) ? customer.getCart() : null;
    }

    private void recalculateCartTotals(Cart cart) {
        int totalQty = cart.getItems().stream().mapToInt(CartItem::getQuantity).sum();
        double totalPrice = cart.getItems().stream()
                .mapToDouble(i -> i.getQuantity() * i.getProduct().getPrice())
                .sum();
        cart.setQuantity(totalQty);
        cart.setTotal(totalPrice);
    }


}
