package com.SpartanSmallBusinessManager.API.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ProviderController.java.
 * Includes all REST API endpoint mappings for the Provider object.
 */
@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService service;

    /**
     * Get a list of all Providers in the database.
     * http://localhost:8080/providers/all
     *
     * @return a list of Provider objects.
     */
    @GetMapping("/all")
    public Object getAllProviders() {
        return new ResponseEntity<>(service.getAllProviders(), HttpStatus.OK);
    }

    /**
     * Create a new Provider entry.
     * http://localhost:8080/providers/new
     *
     * @param provider the new Provider object.
     * @return confirmation message.
     */
    @PostMapping("/new")
    public Object addNewProvider(@RequestBody Provider provider) {
        service.addNewProvider(provider);
        return new ResponseEntity<>("New Provider Successfully Created!", HttpStatus.CREATED);
    }

    /**
     * Update an existing Provider object.
     * http://localhost:8080/providers/update/2
     *
     * @param providerId the unique Provider Id.
     * @param provider   the updated Provider details.
     * @return the updated Provider object.
     */
    @PutMapping("/update/{providerId}")
    public Object updateProvider(@PathVariable int providerId, @RequestBody Provider provider) {
        service.updateProvider(providerId, provider);
        return new ResponseEntity<>(service.getProviderById(providerId), HttpStatus.CREATED);
    }

    /**
     * Delete a Provider object.
     * http://localhost:8080/providers/delete/2
     *
     * @param providerId the unique Provider Id.
     * @return the updated list of Providers.
     */
    @DeleteMapping("/delete/{providerId}")
    public Object deleteProviderById(@PathVariable int providerId) {
        service.deleteProviderById(providerId);
        return new ResponseEntity<>(service.getAllProviders(), HttpStatus.OK);
    }
}
