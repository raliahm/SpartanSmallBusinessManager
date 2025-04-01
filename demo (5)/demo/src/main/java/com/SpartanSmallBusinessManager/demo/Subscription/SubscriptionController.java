package com.SpartanSmallBusinessManager.demo.Subscription;

import com.SpartanSmallBusinessManager.demo.Business.Business;
import com.SpartanSmallBusinessManager.demo.Business.BusinessRepository;
import com.SpartanSmallBusinessManager.demo.Business.BusinessService;
import com.SpartanSmallBusinessManager.demo.Customer.Customer;
import com.SpartanSmallBusinessManager.demo.Customer.CustomerRepository;
import com.SpartanSmallBusinessManager.demo.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BusinessService businessService;


}
