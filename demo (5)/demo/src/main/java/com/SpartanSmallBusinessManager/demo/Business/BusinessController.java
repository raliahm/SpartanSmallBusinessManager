package com.SpartanSmallBusinessManager.demo.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    @GetMapping("/all")
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }


}
