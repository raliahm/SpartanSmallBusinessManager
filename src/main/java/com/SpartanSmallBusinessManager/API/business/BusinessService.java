package com.SpartanSmallBusinessManager.API.business;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import com.SpartanSmallBusinessManager.API.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(int businessId) {
        return businessRepository.findById(businessId).orElse(null);
    }

    public void addNewBusiness(Business business) {
        businessRepository.save(business);
    }

    public void updateBusiness(int businessId, Business business) {
        Business existing = getBusinessById(businessId);
        if (existing != null) {
            existing.setBusinessName(business.getBusinessName());
            existing.setBusinessDescription(business.getBusinessDescription());
            existing.setProvider(business.getProvider());
            businessRepository.save(existing);
        }
    }

    public void deleteBusinessById(int businessId) {
        businessRepository.deleteById(businessId);
    }
}
