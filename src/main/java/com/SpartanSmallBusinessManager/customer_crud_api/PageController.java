package com.SpartanSmallBusinessManager.customer_crud_api;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/home")
    public String homePage(Model model, HttpSession session){
        Integer customerId = (Integer) session.getAttribute("customerId");
        if(customerId == null){
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/customers/createForm")
    public String showSignUpForm(){
        return "customer-create";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }


}
