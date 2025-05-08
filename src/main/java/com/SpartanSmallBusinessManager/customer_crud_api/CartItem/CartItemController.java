package com.SpartanSmallBusinessManager.customer_crud_api.CartItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cartItems")
public class CartItemController {
    @Autowired
    private CartItemService service;

    @GetMapping("/all")
    public String getAllItems(Model model) {
        List<CartItem> items = service.getAllItems();
        model.addAttribute("cartItems", items);
        return "cart/cart-item-list";
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable int id, Model model) {
        CartItem item = service.getItemById(id);
        model.addAttribute("item", item);
        return "cart/cart-item-detail";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("item", new CartItem());
        return "cart/cart-item-form";
    }

    @PostMapping("/new")
    public String addItem(@ModelAttribute CartItem item) {
        service.addItem(item);
        return "redirect:/cartItems/all";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {
        CartItem item = service.getItemById(id);
        model.addAttribute("item", item);
        return "cart/cart-item-form";
    }

    @PostMapping("/update/{id}")
    public String updateItem(@PathVariable int id, @ModelAttribute CartItem item) {
        service.updateItem(id, item);
        return "redirect:/cartItems/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        service.deleteItem(id);
        return "redirect:/cartItems/all";
    }
}
