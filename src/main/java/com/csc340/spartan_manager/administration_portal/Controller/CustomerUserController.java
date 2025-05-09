package com.csc340.spartan_manager.administration_portal.Controller;

import com.csc340.spartan_manager.administration_portal.DTO.CustomerDTO;
import com.csc340.spartan_manager.administration_portal.Entity.CustomerUser;
import com.csc340.spartan_manager.administration_portal.Repository.CustomerUserRepository;
import com.csc340.spartan_manager.administration_portal.Service.CustomerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/customer")
public class CustomerUserController {
    @Autowired
    private CustomerUserService customerUserService;

    @Autowired
    private CustomerUserRepository customerUserRepository;

    @GetMapping("/all")
    public Object getAllCustomerUsers() {
        return new ResponseEntity<>(customerUserService.getAllCustUsers(), HttpStatus.OK);
    }

    @GetMapping("/{custId}")
    public Object getCustomerUser(@PathVariable int custId) {
        return new ResponseEntity<>(customerUserService.getCustUserById(custId), HttpStatus.OK);

    }

    @GetMapping("/username")
    public Object getCustomerUserByUsername(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(customerUserService.getCustByUsername(search), HttpStatus.OK);
    }

    @PostMapping("/new")
    public Object addNewCustUser(@RequestBody CustomerDTO dto) {
        System.out.println("Received DTO: " + dto);
        CustomerUser newCustomer = new CustomerUser();

// Print custUsername
        System.out.println("Received Username: " + dto.getCustUsername());
        newCustomer.setCustUsername(dto.getCustUsername());
        System.out.println("Set Username: " + newCustomer.getCustUsername());

// Print custPassword
        System.out.println("Received Password: " + dto.getCustPassword());
        newCustomer.setPassword(dto.getCustPassword());
        System.out.println("Set Password: " + newCustomer.getPassword());

// Print custName
        System.out.println("Received Name: " + dto.getCustName());
        newCustomer.setCustName(dto.getCustName());
        System.out.println("Set Name: " + newCustomer.getCustName());

// Print custEmail
        System.out.println("Received Email: " + dto.getCustEmail());
        newCustomer.setCustEmail(dto.getCustEmail());
        System.out.println("Set Email: " + newCustomer.getCustEmail());

// Print custPhone
        System.out.println("Received Phone: " + dto.getCustPhone());
        newCustomer.setCustPhone(dto.getCustPhone());
        System.out.println("Set Phone: " + newCustomer.getCustPhone());

// Print custAddress
        System.out.println("Received Address: " + dto.getCustAddress());
        newCustomer.setCustAddress(dto.getCustAddress());
        System.out.println("Set Address: " + newCustomer.getCustAddress());

// Print custCity
        System.out.println("Received City: " + dto.getCustCity());
        newCustomer.setCustCity(dto.getCustCity());
        System.out.println("Set City: " + newCustomer.getCustCity());

// Print custZip
        System.out.println("Received Zip: " + dto.getCustZip());
        newCustomer.setCustZip(dto.getCustZip());
        System.out.println("Set Zip: " + newCustomer.getCustZip());

// Print custState
        System.out.println("Received State: " + dto.getCustState());
        newCustomer.setCustState(dto.getCustState());
        System.out.println("Set State: " + newCustomer.getCustState());

// Print custCountry
        System.out.println("Received Country: " + dto.getCustCountry());
        newCustomer.setCustCountry(dto.getCustCountry());
        System.out.println("Set Country: " + newCustomer.getCustCountry());

// Print Created At timestamp
        newCustomer.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        System.out.println("Set CreatedAt: " + newCustomer.getCreatedAt());

        customerUserService.addNewCustUser(newCustomer);

        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @PutMapping("/update/{custId}")
    public Object updateCustUser(@PathVariable int custId, @RequestBody CustomerUser custUser) {
        customerUserService.updateCustUser(custId, custUser);
        return new ResponseEntity<>(customerUserService.getCustUserById(custId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{custId}")
    public Object deleteCustUser(@PathVariable int custId) {
        customerUserService.deleteCustUser(custId);
        return new ResponseEntity<>(customerUserService.getAllCustUsers(), HttpStatus.OK);
    }


    @GetMapping("/getCustomerCount")
    public Object getCustomerCount() {
        return new ResponseEntity<>(customerUserService.getCustCount(), HttpStatus.OK);
    }

    @PutMapping("/unrestrict/{custId}")
    public Object unRestrict(@PathVariable int custId) {
        return new ResponseEntity<>(customerUserService.unrestrictCustomer(custId), HttpStatus.OK);
    }
    @PutMapping("/restrict/{custId}")
    public Object setRestriction(@PathVariable int custId) {
        return new ResponseEntity<>(customerUserService.restrictCustomer(custId), HttpStatus.OK);
    }

    @GetMapping("/isRestricted/{custId}")
    public Object isRestrict(@PathVariable int custId) {
        return new ResponseEntity<>(customerUserService.isRestricted(custId), HttpStatus.OK);
    }
    @PutMapping("/{custId}/approve")
    public Object approveCustomer(@PathVariable int custId) {
        if(customerUserService.approve(custId)) {
            return new ResponseEntity<>(customerUserService.getCustUserById(custId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerUserService.approve(custId), HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/{custId}/reject")
    public Object rejectCustomer(@PathVariable int custId) {
        if(customerUserService.reject(custId)) {
            return new ResponseEntity<>(customerUserService.getCustUserById(custId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerUserService.reject(custId), HttpStatus.NOT_ACCEPTABLE);
    }
}
