package com.csc340.spartan_manager.administration_portal.Controller;
import com.csc340.spartan_manager.administration_portal.Entity.AdminUser;
import com.csc340.spartan_manager.administration_portal.Service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/admins")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;


    @GetMapping("/all")
    public Object getAllAdminUsers() {
        return new ResponseEntity<>(adminUserService.getAllAdminUsers(), HttpStatus.OK);
    }

    @GetMapping("/admins/{adminId}")
    public Object getAdminUser(@PathVariable Long adminId) {
        return new ResponseEntity<>(adminUserService.getAdminUserById(adminId), HttpStatus.OK);
    }

    @GetMapping("/username")
    public Object getAdminUserByUsername(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(adminUserService.getAdminUsersByAdminUsername(search), HttpStatus.OK);
    }


    @PostMapping("/new")
    public Object registerAdmin(@RequestBody AdminUser adminUser) {
        if (adminUserService.addNewAdminUser(adminUser)) {
            return new ResponseEntity<>(adminUserService.getAllAdminUsers(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{adminId}")
    public Object updateAdminUser(@PathVariable Long adminId, @RequestBody AdminUser adminUser) {
        adminUserService.updateAdmin(adminId, adminUser);
        return new ResponseEntity<>(adminUserService.getAdminUserById(adminId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{adminId}")
    public Object deleteAdminUser(@PathVariable Long adminId) {
        adminUserService.deleteAdminUserById(adminId);
        return new ResponseEntity<>(adminUserService.getAllAdminUsers(), HttpStatus.OK);
    }
}
