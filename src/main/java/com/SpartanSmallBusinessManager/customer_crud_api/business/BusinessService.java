package com.SpartanSmallBusinessManager.API.business;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(int id) {
        return businessRepository.findById(id).orElse(null);
    }

    public Business getBusinessByProvider(Provider provider) {
        return businessRepository.findByProvider(provider);
    }

    public void addNewBusiness(Business business) {
        businessRepository.save(business);
    }

    public void updateBusiness(Business updated) {
        Business existing = getBusinessById(updated.getBusinessId());
        if (existing != null) {
            existing.setBusinessName(updated.getBusinessName());
            existing.setBusinessDescription(updated.getBusinessDescription());
            if (updated.getLogoUrl() != null && !updated.getLogoUrl().isEmpty()) {
                existing.setLogoUrl(updated.getLogoUrl());
            }
            businessRepository.save(existing);
        }
    }

    public void deleteBusinessById(int id) {
        businessRepository.deleteById(id);
    }
}
