package com.SpartanSmallBusinessManager.customer_crud_api.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @Autowired
    private CartRepository repository;

    /**
     * Gets all carts from the table.
     * http://localhost:8080/cart/all
     * @return
     */
    @GetMapping("/all")
    public String getAllCarts(Model model) {
        model.addAttribute("carts", service.getAllCarts());
        return "cart/cart-list";
    }

    /**
     * Get a single cart.
     * http://localhost:8080/cart/1
     * @param cartId
     * @return
     */
    @GetMapping("/{cartId}")
    public String getCartById(@PathVariable int cartId, Model model) {
        model.addAttribute("cart", service.getCartById(cartId));
        return "cart/cart-detail";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("cart", new Cart());
        return "cart/cart-form";
    }

    /**
     * Creates a new cart.
     * http://localhost:8080/cart/new
     * @param cart
     * @return
     */
    @PostMapping("/new")
    public String addCart(@ModelAttribute Cart cart){
        service.addCart(cart);
        return "redirect:/cart/all";
    }
    @PostMapping("/addProduct")
    public String addProductToCart(@RequestParam int customerId, @RequestParam int productId, @RequestParam int quantity) {
        service.addProductToCart(customerId, productId, quantity);
        return "redirect:/cart/view/" + customerId;
    }
    @GetMapping("/update/{cartId}")
    public String updateForm(@PathVariable int cartId, Model model) {
        model.addAttribute("cart", service.getCartById(cartId));
        return "cart/cart-form";
    }

    /**
     * Updates cart.
     * http://localhost:8080/cart/update/2
     * @param cartId
     * @param cart
     * @return
     */
    @PutMapping("/update/{cartId}")
    public String updateCart(@PathVariable int cartId, @ModelAttribute Cart cart){
        service.updateCart(cart, cartId);
        return "redirect:/cart/all";

    }

    /**
     * Deletes cart (or clears cart).
     * http://localhost:8080/cart/delete/2
     * @param cartId
     * @return
     */
    @DeleteMapping("/delete/{cartId}")
    public String deleteCart(@PathVariable int cartId){
        service.deleteCart(cartId);
        return "redirect:/cart/all";
    }
    @GetMapping("/view/{customerId}")
    public String viewCart(@PathVariable int customerId, Model model) {
        Cart cart = repository.findByCustomerCustomerId(customerId);
        model.addAttribute("cart", cart);
        return "cart/cart-view";
    }
    @PostMapping("/removeProduct")
    public String removeProductFromCart(@RequestParam int customerId, @RequestParam int productId) {
        service.removeProductFromCart(customerId, productId);
        return "redirect:/cart/view/" + customerId;
    }
}
