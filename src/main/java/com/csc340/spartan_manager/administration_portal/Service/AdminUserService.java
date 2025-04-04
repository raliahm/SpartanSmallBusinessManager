package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.AdminUser;
import com.csc340.spartan_manager.administration_portal.Repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {
    @Autowired
    private AdminUserRepository adminUserRepository;

    public List<AdminUser> getAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    public AdminUser getAdminUserById(Long adminId) {
        return (AdminUser) adminUserRepository.findById(adminId);
    }

    public AdminUser getAdminUsersByAdminUsername(String username) {
        return (AdminUser) adminUserRepository.getAdminUsersByAdminUsername(username);
    }

    public void addNewAdminUser(AdminUser adminUser) {
        adminUserRepository.save(adminUser);
    }
    public void updateAdmin(Long adminId, AdminUser adminUser) {
        AdminUser existing = getAdminUserById(adminId);
        existing.setEmail(adminUser.getEmail());
        existing.setPassword(adminUser.getPassword());
        adminUserRepository.save(existing);
    }

    public void deleteAdminUserById(int adminId) {
        adminUserRepository.deleteById(adminId);
    }

    public boolean authenticate(String username, String password) {
        Optional<AdminUser> userOpt = Optional.ofNullable(getAdminUsersByAdminUsername(username));

        if (userOpt.isPresent()) {
            AdminUser user = userOpt.get();
            return user.getPassword().equals(password); // Check the password against the stored one
        } else {
            return false; // User not found
        }
    }

}
