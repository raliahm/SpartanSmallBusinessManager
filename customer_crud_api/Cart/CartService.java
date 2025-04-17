package com.SpartanSmallBusinessManager.customer_crud_api.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

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
        cartRepository.save(existing);

    }
    public void deleteCart(int cartId) {
        cartRepository.deleteById(cartId);
    }



}
