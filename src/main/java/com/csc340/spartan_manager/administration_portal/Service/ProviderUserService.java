package com.csc340.spartan_manager.administration_portal.Service;
import com.csc340.spartan_manager.administration_portal.Entity.Business;
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
            // Check and update the email
            if (existing.getEmail() != null && !existing.getEmail().equals(providerUser.getEmail())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "email",
                        existing.getEmail(), providerUser.getEmail(), "Updated provider email");
                existing.setEmail(providerUser.getEmail());
            }

            // Check and update the provider name
            if (existing.getProviderName() != null && !existing.getProviderName().equals(providerUser.getProviderName())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "provider_name",
                        existing.getProviderName(), providerUser.getProviderName(), "Updated provider name");
                existing.setProviderName(providerUser.getProviderName());
            }

            // Check and update the username
            if (existing.getUsername() != null && !existing.getUsername().equals(providerUser.getUsername())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "username",
                        existing.getUsername(), providerUser.getUsername(), "Updated provider username");
                existing.setUsername(providerUser.getUsername());
            }

            // Check and update the phone number
            if (existing.getPhoneNumber() != null && !existing.getPhoneNumber().equals(providerUser.getPhoneNumber())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "phone_number",
                        existing.getPhoneNumber(), providerUser.getPhoneNumber(), "Updated provider phone number");
                existing.setPhoneNumber(providerUser.getPhoneNumber());
            }

            // Check and update the address
            if (existing.getProviderUserAddress() != null && !existing.getProviderUserAddress().equals(providerUser.getProviderUserAddress())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "provider_address",
                        existing.getProviderUserAddress(), providerUser.getProviderUserAddress(), "Updated provider address");
                existing.setProviderUserAddress(providerUser.getProviderUserAddress());
            }

            // Check and update the state
            if (existing.getProviderUserState() != null && !existing.getProviderUserState().equals(providerUser.getProviderUserState())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "provider_state",
                        existing.getProviderUserState(), providerUser.getProviderUserState(), "Updated provider state");
                existing.setProviderUserState(providerUser.getProviderUserState());
            }

            // Check and update the city
            if (existing.getProviderUserCity() != null && !existing.getProviderUserCity().equals(providerUser.getProviderUserCity())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "provider_city",
                        existing.getProviderUserCity(), providerUser.getProviderUserCity(), "Updated provider city");
                existing.setProviderUserCity(providerUser.getProviderUserCity());
            }

            // Check and update the zip code
            if (existing.getProviderUserZip() != null && !existing.getProviderUserZip().equals(providerUser.getProviderUserZip())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "provider_zip",
                        existing.getProviderUserZip(), providerUser.getProviderUserZip(), "Updated provider zip code");
                existing.setProviderUserZip(providerUser.getProviderUserZip());
            }

            // Check and update the country
            if (existing.getProviderUserCountry() != null && !existing.getProviderUserCountry().equals(providerUser.getProviderUserCountry())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "provider_country",
                        existing.getProviderUserCountry(), providerUser.getProviderUserCountry(), "Updated provider country");
                existing.setProviderUserCountry(providerUser.getProviderUserCountry());
            }

            // Check and update the restricted status
            if (existing.isRestricted() != providerUser.isRestricted()) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "restricted",
                        existing.isRestricted() ? "Yes" : "No", providerUser.isRestricted() ? "Yes" : "No", "Updated provider restricted status");
                existing.setRestricted(providerUser.isRestricted());
            }

            // Check and update the provider status (assuming this field exists)
            if (existing.getState() != null && !existing.getState().equals(providerUser.getState())) {
                updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "state",
                        existing.getState(), providerUser.getState(), "Updated provider status");
                existing.setState(providerUser.getState());
            }

            // Save the updated provider
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
    public boolean reject(int providerId){
        ProviderUser providerUser = getProviderUserByProviderId(providerId);
        if (providerUser != null) {
            String oldState = providerUser.getState();
            providerUser.setState("Rejected");
            providerUserRepository.save(providerUser);
            updateLogger.logUpdate(providerId, "UPDATE", "provider_users", "state", oldState, "Rejected", "Approved provider user");

            return true;
        }
        return false;
    }


    public boolean restrictProvider(int id){
        Optional<ProviderUser> existing = providerUserRepository.findById(id);

        if (existing.isPresent()) {
            existing.get().setRestricted(true);  // Set the status to "restricted"
            updateLogger.logUpdate(id, "UPDATE", "providers", "restricted", "false", existing.get().getProviderName(), "Restricted provider");
            providerUserRepository.save(existing.get());  // Save the updated provider
            return true;
        }
        return false;
    }
    public boolean unrestrictProvider(int id){
        Optional<ProviderUser> existing = providerUserRepository.findById(id);
        if (existing.isPresent()) {
            existing.get().setRestricted(false);  // Set it to unrestricted
            updateLogger.logUpdate(id, "UPDATE", "providers", "restricted", "false", existing.get().getProviderName(),"Unrestricted provider");
            providerUserRepository.save(existing.get());  // Save the updated provider
            return true;
        } else {
            return false;  // Return false if the provider doesn't exist
        }
    }

    public boolean isRestricted(int id) {
        return providerUserRepository.findById(id).get().isRestricted();
    }

}
