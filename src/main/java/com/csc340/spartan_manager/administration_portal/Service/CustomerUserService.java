package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.Business;
import com.csc340.spartan_manager.administration_portal.Entity.CustomerUser;
import com.csc340.spartan_manager.administration_portal.Repository.CustomerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserService {
    @Autowired
    private CustomerUserRepository customerUserRepository;

    public List<CustomerUser> getAllCustUsers() {
        return customerUserRepository.findAll();
    }

    public CustomerUser getCustUserById(Long id) {
        return (CustomerUser) customerUserRepository.findByCustId(id);
    }

    public void addNewCustUser(CustomerUser custUser) {



        customerUserRepository.save(custUser);
    }

    public void updateCustUser(Long id, CustomerUser custUser) {
        CustomerUser existing = getCustUserById(id);
        existing.setCustEmail(custUser.getCustEmail());
        existing.setPassword(custUser.getPassword());

        customerUserRepository.save(existing);
    }

    public void deleteCustUser(Long id) {
        customerUserRepository.deleteById(id);
    }

    public Object getCustByUsername(String custUsername) {
       return customerUserRepository.findByCustUsername(custUsername);
    }

    public long getCustCount() {
        return customerUserRepository.count();
    }

    public boolean restrictCustomer( long id){
        Optional<CustomerUser> existing = customerUserRepository.findById(id);
        if (existing.isPresent()) {
            CustomerUser cust = existing.get();
            cust.setRestricted(true);  // Set the status to "restricted"
            customerUserRepository.save(cust);  // Save the updated business
            return true;
        } else {
            return false;  // Return false if the business doesn't exist
        }
    }
    public boolean unrestrictCustomer( long id){
        Optional<CustomerUser> existing = customerUserRepository.findById(id);
        if (existing.isPresent()) {
            CustomerUser cust = existing.get();
            cust.setRestricted(false);  // Set it to unrestricted
            customerUserRepository.save(cust);  // Save the updated business
            return true;
        } else {
            return false;  // Return false if the business doesn't exist
        }
    }

    public boolean isRestricted( long id) {
        return customerUserRepository.findById(id).get().isRestricted();
    }
}
