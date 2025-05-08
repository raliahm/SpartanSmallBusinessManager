package com.SpartanSmallBusinessManager.customer_crud_api.CartItem;

import com.SpartanSmallBusinessManager.customer_crud_api.Cart.Cart;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.Product;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getAllItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getItemById(int cartItemId) {
        return cartItemRepository.findById(cartItemId).orElse(null);
    }

    public void addItem(CartItem item) {
        cartItemRepository.save(item);
    }

    public void updateItem(int cartItemId, CartItem updatedItem) {
        CartItem existing = getItemById(cartItemId);
        if (existing != null) {
            existing.setQuantity(updatedItem.getQuantity());
            existing.setProduct(updatedItem.getProduct());
            existing.setCart(updatedItem.getCart());
            cartItemRepository.save(existing);
        }
    }

    public void deleteItem(int cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }


}
