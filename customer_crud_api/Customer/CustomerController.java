package com.SpartanSmallBusinessManager.customer_crud_api.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    /**
     * Get all customers.
     * http://localhost:8080/customers/all
     * @return
     */
    @GetMapping("/all")
    public Object getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    /**
     * Get a single customer.
     * http://localhost:8080/customers/8890
     * @param customerId
     * @return
     */
    @GetMapping("/{customerId}")
    public Object getACustomer(@PathVariable int customerId) {
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    /**
     * Get customers by their name.
     * http://localhost:8080/customers/name?search=Grace
     * @param search
     * @return
     */
    @GetMapping("/name")
    public Object getCustomerByName(@RequestParam(name = "search") String search) {
        return new ResponseEntity<>(service.getCustomerByName(search), HttpStatus.OK);
    }

    /**
     * Get customers by their usernames.
     * http://localhost:8080/customers/username?search=Gigi101
     * @param search
     * @return
     */
    @GetMapping("/username")
    public Object getCustomerByUsername(@RequestParam(name = "search") String search) {
        return new ResponseEntity<>(service.getCustomerByUsername(search), HttpStatus.OK);
    }

    /**
     * Create a customer profile.
     * http://localhost:8080/customers/new
     * @param customer
     * @return
     */
    @PostMapping("/new")
    public Object createCustomer(@RequestBody Customer customer) {
        service.createCustomer(customer);
        return new ResponseEntity<>("New customer created successfully!", HttpStatus.CREATED);
    }

    /**
     * Update customer profiles.
     * http://localhost:8080/customers/update/8890
     * @param customerId
     * @param customer
     * @return
     */
    @PutMapping("/update/{customerId}")
    public Object updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        service.updateCustomer(customerId, customer);
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    /**
     * Get customer based on their grade level.
     * http://localhost:8080/customers/gradeLevel/Junior
     * @param gradeLevel
     * @return
     */
    @GetMapping("/gradeLevel/{gradeLevel}")
    public Object getCustomerGradeLevel(@PathVariable String gradeLevel) {
        return new ResponseEntity<>(service.getCustomerByGradeLevel(gradeLevel), HttpStatus.OK);
    }


    /**
     * Delete customer from table.
     * http://localhost:8080/customers/delete/8891
     * @param customerId
     * @return
     */
    @DeleteMapping("/delete/{customerId}")
    public Object deleteCustomer(@PathVariable int customerId) {
        service.deleteCustomerById(customerId);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }
}
