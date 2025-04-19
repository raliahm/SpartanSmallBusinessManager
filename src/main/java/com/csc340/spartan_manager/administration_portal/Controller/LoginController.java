package com.csc340.spartan_manager.administration_portal.Controller;
import com.csc340.spartan_manager.administration_portal.Entity.AdminUser;
import com.csc340.spartan_manager.administration_portal.Service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:50297")
@RestController

@RequestMapping("/user")
public class LoginController {
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();

        boolean isAuthenticated = adminUserService.authenticate(username, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("{\"status\":\"success\"}");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"status\":\"failed\"}");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AdminUser adminUser) {
        adminUserService.addNewAdminUser(adminUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\":\"user created\"}");
    }
}
