package com.csc340.spartan_manager.administration_portal.Controller;



import com.csc340.spartan_manager.administration_portal.DTO.BusinessDTO;
import com.csc340.spartan_manager.administration_portal.Entity.Business;
import com.csc340.spartan_manager.administration_portal.Entity.ProviderUser;
import com.csc340.spartan_manager.administration_portal.Repository.ProviderUserRepository;
import com.csc340.spartan_manager.administration_portal.Service.BusinessService;
import com.csc340.spartan_manager.administration_portal.Service.ProviderUserService;
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
    private ProviderUserService providerUserService;

    @Autowired
    private ProviderUserRepository providerRepository;

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
     * Get a list of all Businesses in the database.
     * http://localhost:8080/businesses/all
     *
     * @return a list of Business objects.
     */
    @GetMapping("/{businessId}")
    public Object getBusinessesById(@PathVariable int businessId) {
        return new ResponseEntity<>(service.getBusinessById(businessId), HttpStatus.OK);
    }


    /**
     * Create a new Business entry.
     * http://localhost:8080/businesses/new
     *
     * @param dto the new Business object.
     * @return confirmation message.
     */

    @PostMapping("/new")
    public Object addNewBusiness(@RequestBody BusinessDTO dto) {
        // Get the provider
        ProviderUser provider = providerUserService.getProviderUserByProviderId(dto.getProvider_id());
        if (provider == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid provider ID");
        }

        // Build your Business object
        Business business = new Business();
        business.setBusinessName(dto.getBusiness_name());
        business.setBusinessAddress(dto.getBusiness_address());
        business.setCategory(dto.getCategory());
        business.setProvider(provider);
        business.setBusinessDescription(dto.getBusiness_description());
        business.setRestricted(false);
        business.setStatus("Pending");
        Business b = service.addNewBusiness(business);

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

        //creating a session id and session log for each user, if they have been updated, deleted, or added


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


    @GetMapping("/getBusinessCount")
    public Object getBusinessCount() {
        return new ResponseEntity<>(service.getBusinessCount(), HttpStatus.OK);
    }

    @PutMapping("/unrestrict/{businessID}")
    public Object unRestrict(@PathVariable int businessID) {
        return new ResponseEntity<>(service.unrestrictBusiness(businessID), HttpStatus.OK);
    }
    @PutMapping("/restrict/{businessID}")
    public Object setRestriction(@PathVariable int businessID) {
        return new ResponseEntity<>(service.restrictBusiness(businessID), HttpStatus.OK);
    }

    @GetMapping("/isRestricted/{businessID}")
    public Object isRestrict(@PathVariable int businessID) {
        return new ResponseEntity<>(service.isRestricted(businessID), HttpStatus.OK);
    }

    @PutMapping("/{businessID}/approve")
    public Object approveBusiness(@PathVariable int businessID) {
        if(service.approve(businessID)) {
            return new ResponseEntity<>(service.getBusinessById(businessID), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.approve(businessID), HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/{businessID}/reject")
    public Object rejectBusiness(@PathVariable int businessID) {
        if(service.reject(businessID)) {
            return new ResponseEntity<>(service.reject(businessID), HttpStatus.OK);
        }
        return new ResponseEntity<>(service.reject(businessID), HttpStatus.NOT_ACCEPTABLE);
    }


}