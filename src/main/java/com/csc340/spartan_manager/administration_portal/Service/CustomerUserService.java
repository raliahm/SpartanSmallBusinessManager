package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.CustomerUser;
import com.csc340.spartan_manager.administration_portal.Repository.CustomerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        existing.setEmail(custUser.getEmail());
        existing.setPassword(custUser.getPassword());

        customerUserRepository.save(existing);
    }

    public void deleteCustUser(Long id) {
        customerUserRepository.deleteById(id);
    }

    public Object getCustByUsername(String custUsername) {
       return customerUserRepository.findByCustUsername(custUsername);
    }
}
