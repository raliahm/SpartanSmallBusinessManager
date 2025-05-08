package com.SpartanSmallBusinessManager.customer_crud_api.CartItem;

import com.SpartanSmallBusinessManager.customer_crud_api.Cart.Cart;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    CartItem findByCartAndProduct(Cart cart, Product product);
}
