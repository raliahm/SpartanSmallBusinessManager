package com.csc340.spartan_manager.administration_portal.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index.html"; // This should be in your templates folder
    }

    @GetMapping("/smallbusiness")
    public String smallBusiness() {

        return "small-business.html";
    }

    @GetMapping("/student")
    public String student() {
        return "student.html";
    }

    @GetMapping("/analytics")
    public String analytics() {
        return "analytics.html";
    }

    @GetMapping("/usagedetails")
    public String usageDetails() {
        return "usage-details.html";
    }






}
