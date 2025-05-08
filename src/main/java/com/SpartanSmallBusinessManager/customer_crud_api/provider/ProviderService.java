package com.SpartanSmallBusinessManager.API.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(int providerId) {
        return providerRepository.findById(providerId).orElse(null);
    }

    public void addNewProvider(Provider provider) {
        providerRepository.save(provider);
    }

    public void updateProvider(int providerId, Provider updated) {
        Provider existing = getProviderById(providerId);
        if (existing != null) {
            existing.setProviderName(updated.getProviderName());
            existing.setUsername(updated.getUsername());
            existing.setEmail(updated.getEmail());
            existing.setPassword(updated.getPassword());
            providerRepository.save(existing);
        }
    }

    public void deleteProviderById(int providerId) {
        providerRepository.deleteById(providerId);
    }

    public Provider findByUsernameAndPassword(String username, String password) {
        return providerRepository.findAll().stream()
                .filter(p -> p.getUsername().equals(username) && p.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}
