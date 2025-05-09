package com.SpartanSmallBusinessManager.API.provider;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String showProviderPage(HttpSession session, Model model) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) {
            return "redirect:/login";
        }
        model.addAttribute("provider", provider);
        return "provider";
    }

    @PostMapping("/update")
    public String updateProvider(@ModelAttribute Provider updatedProvider, HttpSession session) {
        Provider existingProvider = (Provider) session.getAttribute("provider");
        if (existingProvider == null) {
            return "redirect:/login";
        }
        providerService.updateProvider(existingProvider.getProviderId(), updatedProvider);
        Provider refreshed = providerService.getProviderById(existingProvider.getProviderId());
        session.setAttribute("provider", refreshed);
        return "redirect:/provider";
    }

    @GetMapping("/delete")
    public String deleteCurrentProvider(HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider != null) {
            providerService.deleteProviderById(provider.getProviderId());
            session.invalidate();
        }
        return "redirect:/login";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvider(@PathVariable int id, HttpSession session) {
        providerService.deleteProviderById(id);
        session.invalidate();
        return "redirect:/login";
    }
}
