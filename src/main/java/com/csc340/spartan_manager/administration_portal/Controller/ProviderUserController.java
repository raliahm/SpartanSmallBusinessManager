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
    public Object getProviderUser(@PathVariable Long providerId) {
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
    public Object updateProviderUser(@PathVariable Long providerId, @RequestBody ProviderUser providerUser) {
        providerUserService.updateProvider(providerId, providerUser);
        return new ResponseEntity<>(providerUserService.getProviderUserByProviderId(providerId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{providerId}")
    public Object deleteProviderUser(@PathVariable Long providerId) {
        providerUserService.deleteProviderUserById(providerId);
        return new ResponseEntity<>(providerUserService.getAllProviderUsers(), HttpStatus.OK);
    }
}