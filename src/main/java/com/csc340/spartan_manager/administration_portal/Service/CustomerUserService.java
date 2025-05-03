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

    public CustomerUser getCustUserById(int id) {
        return customerUserRepository.findById(id).orElse(null);
    }

    public void addNewCustUser(CustomerUser custUser) {

        customerUserRepository.save(custUser);
    }

    public void updateCustUser(int id, CustomerUser custUser) {
        CustomerUser existing = getCustUserById(id);
        existing.setCustEmail(custUser.getCustEmail());
        existing.setPassword(custUser.getPassword());

        customerUserRepository.save(existing);
    }

    public void deleteCustUser(int id) {
        customerUserRepository.deleteById(id);
    }

    public Object getCustByUsername(String custUsername) {
       return customerUserRepository.findByCustUsername(custUsername);
    }

    public long getCustCount() {
        return customerUserRepository.count();
    }

    public boolean restrictCustomer( int id){
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
    public boolean unrestrictCustomer( int id){
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

    public boolean isRestricted( int id) {
        return customerUserRepository.findById(id).get().isRestricted();
    }

    public boolean approve( int id) {
        Optional<CustomerUser> existing = customerUserRepository.findById(id);
        if (existing.isPresent()) {
            CustomerUser cust = existing.get();
            cust.setCustState("Approved");
            customerUserRepository.save(cust);
            return true;
        }
        return false;
    }

    public boolean reject( int id) {
        Optional<CustomerUser> existing = customerUserRepository.findById(id);
        if (existing.isPresent()) {
            CustomerUser cust = existing.get();
            cust.setState("Rejected");
            customerUserRepository.save(cust);
            return true;
        }
        return false;
    }
}
