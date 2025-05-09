package com.csc340.spartan_manager.administration_portal.Controller;

import com.csc340.spartan_manager.administration_portal.Entity.ProviderUser;
import com.csc340.spartan_manager.administration_portal.Service.ProviderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/providers")
public class ProviderUserController {
    @Autowired
    private ProviderUserService providerUserService;

    @GetMapping("/all")
    public Object getAllProviderUsers() {
        return new ResponseEntity<>(providerUserService.getAllProviderUsers(), HttpStatus.OK);
    }

    @GetMapping("/{providerId}")
    public Object getProviderUser(@PathVariable int providerId) {
        return new ResponseEntity<>(providerUserService.getProviderUserByProviderId(providerId), HttpStatus.OK);
    }

    @GetMapping("/username")
    public Object getProviderUserByUsername(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(providerUserService.getProviderUsersByProviderUsername(search), HttpStatus.OK);
    }


    @PostMapping("/new")
    public Object addNewProviderUser(@RequestBody ProviderUser providerUser) {
        providerUserService.addNewProviderUser(providerUser);
        return new ResponseEntity<>(providerUserService.getAllProviderUsers(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{providerId}")
    public Object updateProviderUser(@PathVariable int providerId, @RequestBody ProviderUser providerUser) {
        providerUserService.updateProvider(providerId, providerUser);
        return new ResponseEntity<>(providerUserService.getProviderUserByProviderId(providerId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{providerId}")
    public Object deleteProviderUser(@PathVariable int providerId) {
        providerUserService.deleteProviderUserById(providerId);
        return new ResponseEntity<>(providerUserService.getAllProviderUsers(), HttpStatus.OK);
    }

    @GetMapping("/getProviderUserCount")
    public Object getProviderUserCount() {
        return new ResponseEntity<>(providerUserService.getProviderUserCount(), HttpStatus.OK);
    }

    @PutMapping("/{providerId}/approve")
    public Object approveProvider(@PathVariable int providerId) {
        if(providerUserService.approve(providerId)) {
            return new ResponseEntity<>(providerUserService.getProviderUserByProviderId(providerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(providerUserService.approve(providerId), HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/{providerId}/reject")
    public Object rejectProvider(@PathVariable int providerId) {
        if(providerUserService.reject(providerId)) {
            return new ResponseEntity<>(providerUserService.getProviderUserByProviderId(providerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(providerUserService.reject(providerId), HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/unrestrict/{providerId}")
    public Object unRestrictProvider(@PathVariable int providerId) {
        if(providerUserService.unrestrictProvider(providerId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
    @PutMapping("/restrict/{providerId}")
    public Object restrictProvider(@PathVariable int providerId) {
        if(providerUserService.restrictProvider(providerId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping("/isRestricted/{providerId}")
    public Object isRestrict(@PathVariable int providerId) {
        return new ResponseEntity<>(providerUserService.isRestricted(providerId), HttpStatus.OK);
    }
}