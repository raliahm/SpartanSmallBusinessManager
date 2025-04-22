package com.csc340.spartan_manager.administration_portal.Service;



import com.csc340.spartan_manager.administration_portal.Entity.Business;
import com.csc340.spartan_manager.administration_portal.Repository.BusinessRepository;
import com.csc340.spartan_manager.administration_portal.Repository.ProviderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private ProviderUserRepository providerRepository;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(int businessId) {
        return businessRepository.findById(businessId).orElse(null);
    }

    public Business addNewBusiness(Business business) {
        return businessRepository.save(business);
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


    public long getBusinessCount() {
       return businessRepository.count();
    }

    public boolean restrictBusiness(int id){
        Optional<Business> existing = businessRepository.findById(id);
        if (existing.isPresent()) {
            Business business = existing.get();
            business.setRestricted(true);  // Set the status to "restricted"
            businessRepository.save(business);  // Save the updated business
            return true;
        } else {
            return false;  // Return false if the business doesn't exist
        }
    }
    public boolean unrestrictBusiness(int id){
        Optional<Business> existing = businessRepository.findById(id);
        if (existing.isPresent()) {
            Business business = existing.get();
            business.setRestricted(false);  // Set it to unrestricted
            businessRepository.save(business);  // Save the updated business
            return true;
        } else {
            return false;  // Return false if the business doesn't exist
        }
    }

    public boolean isRestricted(int id) {
        return businessRepository.findById(id).get().isRestricted();
    }
}
