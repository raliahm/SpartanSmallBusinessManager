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
    @Autowired
    private EntityUpdateEntryService updateLogger;


    public List<CustomerUser> getAllCustUsers() {
        return customerUserRepository.findAll();
    }

    public CustomerUser getCustUserById(int id) {
        return customerUserRepository.findById(id).orElse(null);
    }

    public void addNewCustUser(CustomerUser custUser) {

        customerUserRepository.save(custUser);
        updateLogger.logUpdate(
                custUser.getCustId(),
                "INSERT",
                "customers",
                null,
                null,
                custUser.getCustUsername(),
                "New customer added"
        );
    }

    public void updateCustUser(int id, CustomerUser custUser) {
        CustomerUser existing = getCustUserById(id);

        if (!existing.getCustEmail().equals(custUser.getCustEmail())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custEmail",
                    existing.getCustEmail(), custUser.getCustEmail(), "Customer email updated");
            existing.setCustEmail(custUser.getCustEmail());
        }

        if (!existing.getPassword().equals(custUser.getPassword())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "password",
                    existing.getPassword(), custUser.getPassword(), "Customer password updated");
            existing.setPassword(custUser.getPassword());
        }

        if (!existing.getCustUsername().equals(custUser.getCustUsername())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custUsername",
                    existing.getCustUsername(), custUser.getCustUsername(), "Customer username updated");
            existing.setCustUsername(custUser.getCustUsername());
        }

        if (!existing.getCustName().equals(custUser.getCustName())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custName",
                    existing.getCustName(), custUser.getCustName(), "Customer name updated");
            existing.setCustName(custUser.getCustName());
        }

        if (!existing.getCustPhone().equals(custUser.getCustPhone())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custPhone",
                    existing.getCustPhone(), custUser.getCustPhone(), "Customer phone updated");
            existing.setCustPhone(custUser.getCustPhone());
        }

        if (!existing.getCustAddress().equals(custUser.getCustAddress())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custAddress",
                    existing.getCustAddress(), custUser.getCustAddress(), "Customer address updated");
            existing.setCustAddress(custUser.getCustAddress());
        }

        if (!existing.getCustCity().equals(custUser.getCustCity())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custCity",
                    existing.getCustCity(), custUser.getCustCity(), "Customer city updated");
            existing.setCustCity(custUser.getCustCity());
        }

        if (!existing.getCustZip().equals(custUser.getCustZip())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custZip",
                    existing.getCustZip(), custUser.getCustZip(), "Customer zip updated");
            existing.setCustZip(custUser.getCustZip());
        }

        if (!existing.getCustState().equals(custUser.getCustState())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custState",
                    existing.getCustState(), custUser.getCustState(), "Customer state updated");
            existing.setCustState(custUser.getCustState());
        }

        if (!existing.getCustCountry().equals(custUser.getCustCountry())) {
            updateLogger.logUpdate(id, "UPDATE", "customers", "custCountry",
                    existing.getCustCountry(), custUser.getCustCountry(), "Customer country updated");
            existing.setCustCountry(custUser.getCustCountry());
        }

        customerUserRepository.save(existing);
    }


    public void deleteCustUser(int id) {
        CustomerUser user = getCustUserById(id);
        customerUserRepository.deleteById(id);
        updateLogger.logUpdate(
                id,
                "DELETE",
                "customers",
                null,
                user.getCustUsername(),
                null,
                "Customer deleted"
        );
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
            updateLogger.logUpdate(id, "UPDATE", "customers", "restricted", "false", "true", "Customer restricted");
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
            updateLogger.logUpdate(id, "UPDATE", "customers", "restricted", "true", "false", "Customer unrestricted");
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
            String oldState = cust.getStatus();
            cust.setStatus("Approved");

            customerUserRepository.save(cust);
            updateLogger.logUpdate(id, "UPDATE", "customers", "custState", oldState, "Approved", "Customer approved");

            return true;
        }
        return false;
    }

    public boolean reject( int id) {
        Optional<CustomerUser> existing = customerUserRepository.findById(id);
        if (existing.isPresent()) {
            CustomerUser cust = existing.get();
            String oldState = cust.getStatus();

            cust.setStatus("Rejected");
            customerUserRepository.save(cust);
            updateLogger.logUpdate(id, "UPDATE", "customers", "status", oldState, "Rejected", "Customer rejected");

            return true;
        }
        return false;
    }
}
