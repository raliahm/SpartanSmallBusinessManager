package com.SpartanSmallBusinessManager.demo.Customer;
import com.SpartanSmallBusinessManager.demo.Subscription.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/all")
    public Object getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public Object addNewCustomer(@RequestBody Customer customer) {
        service.addNewCustomer(customer);
        return new ResponseEntity<>("You have made your new profile!", HttpStatus.CREATED);

    }

    @PostMapping("/{customerId}")
    public Object updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        service.updateCustomer(customer);
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.CREATED);
    }

    //@PostMapping("/subscribe-business/{customerId}/{businessId}")
    //public Object subscribeToBusiness(@PathVariable int customerId, @PathVariable int businessId ) {
        //Customer customer = customerService.getById(customerId);
        //customer.setSubscriptions(new Subscription(businessId));
        //customerService.updateCustomer(customer);
        //return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.CREATED);
    }









