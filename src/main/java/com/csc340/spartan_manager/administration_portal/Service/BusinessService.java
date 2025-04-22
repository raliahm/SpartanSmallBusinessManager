package com.csc340.spartan_manager.administration_portal.Service;



import com.csc340.spartan_manager.administration_portal.Entity.Business;
import com.csc340.spartan_manager.administration_portal.Repository.BusinessRepository;
import com.csc340.spartan_manager.administration_portal.Repository.ProviderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        businessRepository.findById(id).ifPresent(business -> business.setRestricted(true));
        return businessRepository.findById(id).get().isRestricted();
    }
    public boolean unrestrictBusiness(int id){
        businessRepository.findById(id).ifPresent(business -> business.setRestricted(false));
        return businessRepository.findById(id).get().isRestricted();

    }

    public boolean isRestricted(int id) {
        return businessRepository.findById(id).get().isRestricted();
    }
}
