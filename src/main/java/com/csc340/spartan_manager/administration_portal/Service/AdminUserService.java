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


    /**
     * returns all the admin users
     * @return
     */
    public Object getAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    /**
     * return one Admin User given the ID
     * @param adminId
     * @return admin user object
     */
    public Object getAdminUserById(Long adminId) {
        return adminUserRepository.findById(adminId);
    }


    /**
     * Search an admin by their username and get the admin user object back
     * @param search
     * @return
     */
    public Object getAdminUsersByAdminUsername(String search) {
        return adminUserRepository.findByAdminUsername(search);
    }

    /**
     * Updates the exisitng admins
     * @param adminId
     * @param adminUser
     */
    public void updateAdmin(Long adminId, AdminUser adminUser)  {
        AdminUser existingAdmin = adminUserRepository.findById(adminId).get();
        existingAdmin.setAdminBirthday(adminUser.getAdminBirthday());
        existingAdmin.setEmail(adminUser.getEmail());
        existingAdmin.setFullName(adminUser.getFullName());
        existingAdmin.setPhoneNumber(adminUser.getPhoneNumber());
        existingAdmin.setUsername(adminUser.getUsername());
        existingAdmin.setPassword(adminUser.getPassword());
        adminUserRepository.save(existingAdmin);

    }

    public boolean addNewAdminUser(AdminUser adminUser) {
        // You can use email, username, or both depending on your uniqueness constraint
        Optional<AdminUser> existingUser = adminUserRepository.findByAdminUsername(adminUser.getUsername());
        if (existingUser.isPresent()) {
            return false;
        }

        adminUserRepository.save(adminUser);
        return true;
    }

    public void deleteAdminUserById(Long adminId) {
        adminUserRepository.deleteById(adminId);
    }

    public boolean authenticate(String username, String password) {
        AdminUser user = adminUserRepository.findByAdminUsername(username).get();
        return user.getPassword().equals(password);
    }
}
