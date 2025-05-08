package com.SpartanSmallBusinessManager.customer_crud_api.Business;

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

    public List<Business> getBusinessesByName(String name) {

        return businessRepository.getBusinessesByName(name);
    }

    public Business getBusinessById(int businessId) {
        return businessRepository.findById(businessId).orElse(null);
    }

    public void addNewBusiness(Business business) {

        businessRepository.save(business);
    }

    public void updateBusiness(int businessId, Business business) {
        Business existing = businessRepository.findById(businessId)
                .orElseThrow(() -> new RuntimeException("Business with ID " + businessId + " not found."));

        existing.setBusinessName(business.getBusinessName());
        existing.setDescription(business.getDescription());
        existing.setCategory(business.getCategory());

        businessRepository.save(existing);

    }
    public void deleteBusiness(int businessId) {
        businessRepository.deleteById(businessId);
    }
}
