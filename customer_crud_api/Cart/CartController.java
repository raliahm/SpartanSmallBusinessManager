package com.SpartanSmallBusinessManager.customer_crud_api.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    /**
     * Gets all carts from the table.
     * http://localhost:8080/cart/all
     * @return
     */
    @GetMapping("/all")
    public Object getAllCarts() {
        return new ResponseEntity<>(service.getAllCarts(), HttpStatus.OK);
    }

    /**
     * Get a single cart.
     * http://localhost:8080/cart/1
     * @param cartId
     * @return
     */
    @GetMapping("/{cartId}")
    public Object getCartById(@PathVariable int cartId) {
        return new ResponseEntity<>(service.getCartById(cartId), HttpStatus.OK);
    }

    /**
     * Creates a new cart.
     * http://localhost:8080/cart/new
     * @param cart
     * @return
     */
    @PostMapping("/new")
    public Object addCart(@RequestBody Cart cart){
        service.addCart(cart);
        return new ResponseEntity<>("Cart has been created!", HttpStatus.CREATED);
    }

    /**
     * Updates cart.
     * http://localhost:8080/cart/update/2
     * @param cartId
     * @param cart
     * @return
     */
    @PutMapping("/update/{cartId}")
    public Object updateCart(@PathVariable int cartId, @RequestBody Cart cart){
        service.updateCart(cart, cartId);
        return new ResponseEntity<>(service.getCartById(cartId), HttpStatus.OK);

    }

    /**
     * Deletes cart (or clears cart).
     * http://localhost:8080/cart/delete/2
     * @param cartId
     * @return
     */
    @DeleteMapping("/delete/{cartId}")
    public Object deleteCart(@PathVariable int cartId){
        service.deleteCart(cartId);
        return new ResponseEntity<>(service.getAllCarts(), HttpStatus.OK);
    }
}
