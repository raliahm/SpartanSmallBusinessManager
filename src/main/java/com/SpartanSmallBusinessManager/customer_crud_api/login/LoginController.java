package com.SpartanSmallBusinessManager.API.login;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import com.SpartanSmallBusinessManager.API.provider.ProviderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        Provider provider = providerService.findByUsernameAndPassword(username, password);
        if (provider != null) {
            session.setAttribute("provider", provider);
            return "redirect:/provider";
        } else {
            model.addAttribute("loginError", true);
            return "auth/login";
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String providerName,
                         @RequestParam String username,
                         @RequestParam String email,
                         @RequestParam String password,
                         HttpSession session) {

        Provider newProvider = new Provider(providerName, username, email, password);
        providerService.addNewProvider(newProvider);
        session.setAttribute("provider", newProvider);
        return "redirect:/provider";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String redirectToLoginWithSignup() {
        return "redirect:/login";
    }
}
