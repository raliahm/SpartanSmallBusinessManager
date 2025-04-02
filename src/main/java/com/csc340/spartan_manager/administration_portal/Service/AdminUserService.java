package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.AdminUser;
import com.csc340.spartan_manager.administration_portal.Repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
