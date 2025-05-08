package com.SpartanSmallBusinessManager.customer_crud_api;

import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributes {
    @Autowired
    private CustomerService service;

    @ModelAttribute
    public void addLoggedInCustomer(Model model, HttpSession session) {
        Integer customerId = (Integer) session.getAttribute("customerId");
        if (customerId != null) {
            Customer customer = service.getCustomerById(customerId);
            model.addAttribute("customer", customer);
        }
    }
}
