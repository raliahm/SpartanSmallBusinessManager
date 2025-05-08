package com.SpartanSmallBusinessManager.API.business;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping
    public String showBusiness(Model model, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) {
            return "redirect:/login";
        }

        Business business = businessService.getBusinessByProvider(provider);
        if (business == null) {
            business = new Business();
        }

        model.addAttribute("business", business);
        return "business";
    }

    @PostMapping("/create")
    public String createBusiness(@RequestParam("businessName") String name,
                                 @RequestParam("businessDescription") String description,
                                 @RequestParam(value = "logoFile", required = false) MultipartFile logoFile,
                                 HttpSession session) throws IOException {

        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        String logoPath = null;
        if (logoFile != null && !logoFile.isEmpty()) {
            String filename = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
            Path uploadPath = Paths.get("src/main/resources/static/uploads/" + filename);
            Files.createDirectories(uploadPath.getParent());
            Files.write(uploadPath, logoFile.getBytes());
            logoPath = "/uploads/" + filename;
        }

        Business business = new Business(name, description, logoPath, provider);
        businessService.addNewBusiness(business);
        return "redirect:/business";
    }

    @PostMapping("/update/{id}")
    public String updateBusiness(@PathVariable int id,
                                 @RequestParam("businessName") String name,
                                 @RequestParam("businessDescription") String description,
                                 @RequestParam(value = "logoFile", required = false) MultipartFile logoFile,
                                 HttpSession session) throws IOException {

        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        String logoPath = null;
        if (logoFile != null && !logoFile.isEmpty()) {
            String filename = System.currentTimeMillis() + "_" + logoFile.getOriginalFilename();
            Path uploadPath = Paths.get("src/main/resources/static/uploads/" + filename);
            Files.createDirectories(uploadPath.getParent());
            Files.write(uploadPath, logoFile.getBytes());
            logoPath = "/uploads/" + filename;
        }

        Business updated = new Business(name, description, logoPath, provider);
        updated.setBusinessId(id);
        businessService.updateBusiness(updated);
        return "redirect:/business";
    }

    @GetMapping("/delete/{id}")
    public String deleteBusiness(@PathVariable int id, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        Business business = businessService.getBusinessById(id);

        if (business != null && provider != null &&
                business.getProvider().getProviderId() == provider.getProviderId()) {
            businessService.deleteBusinessById(id);
        }

        return "redirect:/business";
    }
}
