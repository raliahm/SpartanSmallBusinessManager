package com.csc340.spartan_manager.administration_portal.Service;



import com.csc340.spartan_manager.administration_portal.Entity.Business;
import com.csc340.spartan_manager.administration_portal.Repository.BusinessRepository;
import com.csc340.spartan_manager.administration_portal.Repository.ProviderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private ProviderUserRepository providerRepository;

    @Autowired
    private EntityUpdateEntryService updateLogger;

    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    public Business getBusinessById(int businessId) {
        return businessRepository.findById(businessId).orElse(null);
    }

    public Business addNewBusiness(Business business) {
        updateLogger.logUpdate(business.getBusinessId(), "INSERT", "buinesses", null, null, business.getBusinessName(), "Added business");

        return businessRepository.save(business);
    }

    public void updateBusiness(int businessId, Business business) {
        Business existing = getBusinessById(businessId);
        if (existing != null) {

            if (!existing.getBusinessName().equals(business.getBusinessName())) {
                updateLogger.logUpdate(businessId, "UPDATE", "Business", "businessName",
                        existing.getBusinessName(), business.getBusinessName(), "Business name updated");
                existing.setBusinessName(business.getBusinessName());
            }

            if (!existing.getBusinessDescription().equals(business.getBusinessDescription())) {
                updateLogger.logUpdate(businessId, "UPDATE", "Business", "businessDescription",
                        existing.getBusinessDescription(), business.getBusinessDescription(), "Business description updated");
                existing.setBusinessDescription(business.getBusinessDescription());
            }

            if (!existing.getStatus().equals(business.getStatus())) {
                updateLogger.logUpdate(businessId, "UPDATE", "Business", "status",
                        existing.getStatus(), business.getStatus(), "Business status updated");
                existing.setStatus(business.getStatus());
            }

            if (!existing.getBusinessAddress().equals(business.getBusinessAddress())) {
                updateLogger.logUpdate(businessId, "UPDATE", "Business", "businessAddress",
                        existing.getBusinessAddress(), business.getBusinessAddress(), "Business address updated");
                existing.setBusinessAddress(business.getBusinessAddress());
            }

            if (!existing.getCategory().equals(business.getCategory())) {
                updateLogger.logUpdate(businessId, "UPDATE", "Business", "category",
                        existing.getCategory(), business.getCategory(), "Business category updated");
                existing.setCategory(business.getCategory());
            }

            businessRepository.save(existing);
        }
    }


    public void deleteBusinessById(int businessId) {
        Business existing = getBusinessById(businessId);
        updateLogger.logUpdate(businessId, "DELETE", "businesses", null, existing.getBusinessName(), null, "Deleted business");
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
            updateLogger.logUpdate(id, "UPDATE", "businesses", "restricted", "false", business.getBusinessName(),"Restricted business");
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
            updateLogger.logUpdate(id, "UPDATE", "businesses", "restricted", "false", business.getBusinessName(),"Unrestricted business");
            businessRepository.save(business);  // Save the updated business
            return true;
        } else {
            return false;  // Return false if the business doesn't exist
        }
    }

    public boolean isRestricted(int id) {
        return businessRepository.findById(id).get().isRestricted();
    }

    public boolean approve(@PathVariable int businessID) {
        Business business = getBusinessById(businessID);
        String oldState = business.getStatus();

        business.setStatus("Approved");
        businessRepository.save(business);
        updateLogger.logUpdate(businessID, "UPDATE", "businesses", "status", oldState, business.getBusinessName(),"Approved business");
        return !business.getStatus().equals("Rejected") && !business.getStatus().equals("Pending");
    }

    public boolean reject(@PathVariable int businessID) {
        Business business = getBusinessById(businessID);
        String oldState = business.getStatus();

        business.setStatus("Rejected");
        businessRepository.save(business);

        updateLogger.logUpdate(businessID, "UPDATE", "businesses", "status", oldState, business.getBusinessName(),"Rejected business");

        return !business.getStatus().equals("Approved") && !business.getStatus().equals("Pending");
    }
}
