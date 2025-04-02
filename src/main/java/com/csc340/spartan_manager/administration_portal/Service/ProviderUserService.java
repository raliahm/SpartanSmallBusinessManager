package com.csc340.spartan_manager.administration_portal.Service;
import com.csc340.spartan_manager.administration_portal.Entity.ProviderUser;
import com.csc340.spartan_manager.administration_portal.Repository.ProviderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderUserService {
    @Autowired
    private ProviderUserRepository providerUserRepository;

    public List<ProviderUser> getAllProviderUsers() {
        return providerUserRepository.findAll();
    }

    public ProviderUser getProviderUserByProviderId(int providerId) {
        return (ProviderUser) providerUserRepository.findByProviderId(providerId);
    }

    public ProviderUser getProviderUsersByProviderUsername(String providerUsername) {
        return (ProviderUser) providerUserRepository.getProviderUsersByProviderUsername(providerUsername);
    }

    public void addNewProviderUser(ProviderUser providerUser) {
        providerUserRepository.save(providerUser);
    }
    public void updateProvider(int providerId, ProviderUser providerUser) {
        ProviderUser existing = getProviderUserByProviderId(providerId);
        existing.setEmail(providerUser.getEmail());
        existing.setPassword(providerUser.getPassword());
        providerUserRepository.save(existing);
    }

    public void deleteProviderUserById(int providerId) {
        providerUserRepository.deleteById(providerId);
    }

}
