package com.SpartanSmallBusinessManager.customer_crud_api.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService service;

    /**
     * Gets list of all businesses.
     * http://localhost:8080/businesses/all
     * @return
     */
    @GetMapping("/all")
    public Object getAllBusinesses(){

        return new ResponseEntity<>(service.getAllBusinesses(), HttpStatus.OK);
    }

    /**
     * Gets businesses by name.
     * http://localhost:8080/businesses/name
     * @param search
     * @return
     */
    @GetMapping("/name")
    public Object getBusinessesByName(@RequestParam(name="search") String search){
        return new ResponseEntity<>(service.getBusinessesByName(search), HttpStatus.OK);
    }

    /**
     * Creates a new business.
     * http://localhost:8080/businesses/new
     * @param business
     * @return
     */
    @PostMapping("/new")
    public Object addNewBusiness(@RequestBody Business business){
        service.addNewBusiness(business);
        return new ResponseEntity<>("Successfully added business", HttpStatus.CREATED);
    }

    /**
     * Updates Business information.
     * http://localhost:8080/businesses/update/2
     * @param business
     * @param businessId
     * @return
     */
    @PutMapping("/update/{businessId}")
    public Object updateBusiness(@RequestBody Business business, @PathVariable int businessId){
        return new ResponseEntity<>(service.getAllBusinesses(), HttpStatus.OK);
    }

    /**
     * Deletes business from the table.
     * http://localhost:8080/businesses/delete/2
     * @param businessId
     * @return
     */
    @DeleteMapping("/delete/{businessId}")
    public Object deleteBusiness(@PathVariable int businessId){
        service.deleteBusiness(businessId);
        return new ResponseEntity<>(service.getAllBusinesses(), HttpStatus.OK);
    }





}
