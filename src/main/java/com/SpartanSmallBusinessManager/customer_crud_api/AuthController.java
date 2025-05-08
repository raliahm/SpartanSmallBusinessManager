package com.SpartanSmallBusinessManager.customer_crud_api;

import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    CustomerService service;

    @GetMapping("/login")
    public String showLogin() {
        return "login";   // returns login.ftlh
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {
        Customer customer = service.authenticate(username, password);
        if (customer != null) {
            session.setAttribute("customerId", customer.getCustomerId());
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}
