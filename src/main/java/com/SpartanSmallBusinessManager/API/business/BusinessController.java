package com.SpartanSmallBusinessManager.API.business;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import com.SpartanSmallBusinessManager.API.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * BusinessController.java.
 * Includes all REST API endpoint mappings for the Business object.
 */
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService service;

    @Autowired
    private ProviderRepository providerRepository;

    /**
     * Get a list of all Businesses in the database.
     * http://localhost:8080/businesses/all
     *
     * @return a list of Business objects.
     */
    @GetMapping("/all")
    public Object getAllBusinesses() {
        return new ResponseEntity<>(service.getAllBusinesses(), HttpStatus.OK);
    }

    /**
     * Create a new Business entry.
     * http://localhost:8080/businesses/new
     *
     * @param business the new Business object.
     * @return confirmation message.
     */
    @PostMapping("/new")
    public Object addNewBusiness(@RequestBody Business business) {
        service.addNewBusiness(business);
        return new ResponseEntity<>("New Business Successfully Created!", HttpStatus.CREATED);
    }

    /**
     * Update an existing Business object.
     * http://localhost:8080/businesses/update/2
     *
     * @param businessId the unique Business Id.
     * @param business   the updated Business details.
     * @return the updated Business object.
     */
    @PutMapping("/update/{businessId}")
    public Object updateBusiness(@PathVariable int businessId, @RequestBody Business business) {
        service.updateBusiness(businessId, business);
        return new ResponseEntity<>(service.getBusinessById(businessId), HttpStatus.CREATED);
    }

    /**
     * Delete a Business object.
     * http://localhost:8080/businesses/delete/2
     *
     * @param businessId the unique Business Id.
     * @return the updated list of Businesses.
     */
    @DeleteMapping("/delete/{businessId}")
    public Object deleteBusinessById(@PathVariable int businessId) {
        service.deleteBusinessById(businessId);
        return new ResponseEntity<>(service.getAllBusinesses(), HttpStatus.OK);
    }
}
