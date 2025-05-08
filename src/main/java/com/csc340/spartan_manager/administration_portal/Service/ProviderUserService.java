package com.csc340.spartan_manager.administration_portal.Service;
import com.csc340.spartan_manager.administration_portal.Entity.ProviderUser;
import com.csc340.spartan_manager.administration_portal.Repository.ProviderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderUserService {
    @Autowired
    private ProviderUserRepository providerUserRepository;

    @Autowired
    private EntityUpdateEntryService updateLogger;

    public List<ProviderUser> getAllProviderUsers() {
        return providerUserRepository.findAll();
    }

    public ProviderUser getProviderUserByProviderId(int providerId) {

       return providerUserRepository.findById(providerId).get();
    }

    public ProviderUser getProviderUsersByProviderUsername(String providerUsername) {
        return (ProviderUser) providerUserRepository.getProviderUsersByProviderUsername(providerUsername);
    }

    public void addNewProviderUser(ProviderUser providerUser) {
        providerUserRepository.save(providerUser);
        updateLogger.logUpdate(providerUser.getProviderID(), "INSERT", "provider_users", "", "", "", "Created provider user");

    }
    public void updateProvider(int providerId, ProviderUser providerUser) {
        ProviderUser existing = getProviderUserByProviderId(providerId);
        if (existing != null) {
            if (!existing.getEmail().equals(providerUser.getEmail())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "email",
                        existing.getEmail(), providerUser.getEmail(), "Updated provider email");
                existing.setEmail(providerUser.getEmail());
            }

            if (!existing.getPassword().equals(providerUser.getPassword())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "password",
                        "********", "********", "Updated provider password");
                existing.setPassword(providerUser.getPassword());
            }
            providerUserRepository.save(existing);
        }
    }

    public void deleteProviderUserById(int providerId) {
        updateLogger.logUpdate(providerId, "DELETE", "provider_users", "", "", "", "Deleted provider user");

        providerUserRepository.deleteById(providerId);
    }

    public long getProviderUserCount() {
        return providerUserRepository.count();
    }

    public boolean approve(int businessId){
        ProviderUser providerUser = getProviderUserByProviderId(businessId);
        if (providerUser != null) {
            String oldState = providerUser.getState();
            providerUser.setState("Approved");
            providerUserRepository.save(providerUser);
            updateLogger.logUpdate(businessId, "UPDATE", "provider_users", "state", oldState, "Approved", "Approved provider user");

            return true;
        }
        return false;
    }
    public boolean reject(int businessId){
        ProviderUser providerUser = getProviderUserByProviderId(businessId);
        if (providerUser != null) {
            String oldState = providerUser.getState();
            providerUser.setState("Rejected");
            providerUserRepository.save(providerUser);
            updateLogger.logUpdate(businessId, "UPDATE", "provider_users", "state", oldState, "Rejected", "Approved provider user");

            return true;
        }
        return false;
    }
}
