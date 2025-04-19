package com.csc340.spartan_manager.administration_portal.Controller;

import com.csc340.spartan_manager.administration_portal.Entity.CustomerUser;
import com.csc340.spartan_manager.administration_portal.Service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/custs")
public class CustomerUserController {
    @Autowired
    private CustomerUserService customerUserService;

    @GetMapping("/all")
    public Object getAllCustomerUsers() {
        return new ResponseEntity<>(customerUserService.getAllCustUsers(), HttpStatus.OK);
    }

    @GetMapping("/{custId}")
    public Object getCustomerUser(@PathVariable Long custId) {
        return new ResponseEntity<>(customerUserService.getCustUserById(custId), HttpStatus.OK);

    }

    @GetMapping("/username")
    public Object getCustomerUserByUsername(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(customerUserService.getCustByUsername(search), HttpStatus.OK);
    }

    @PostMapping("/new")
    public Object addNewCustUser(@RequestBody CustomerUser customerUser) {
        customerUserService.addNewCustUser(customerUser);
        return new ResponseEntity<>(customerUserService.getAllCustUsers(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{custId}")
    public Object updateAdminUser(@PathVariable Long custId, @RequestBody CustomerUser custUser) {
        customerUserService.updateCustUser(custId, custUser);
        return new ResponseEntity<>(customerUserService.getCustUserById(custId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{custId}")
    public Object deleteAdminUser(@PathVariable Long custId) {
        customerUserService.deleteCustUser(custId);
        return new ResponseEntity<>(customerUserService.getAllCustUsers(), HttpStatus.OK);
    }
}
