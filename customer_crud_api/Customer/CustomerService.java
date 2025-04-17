package com.SpartanSmallBusinessManager.customer_crud_api.Customer;

import com.SpartanSmallBusinessManager.customer_crud_api.Business.Business;
import com.SpartanSmallBusinessManager.customer_crud_api.Business.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }


    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(int customerId, Customer customer) {
        Customer existing = getCustomerById(customerId);
        existing.setName(customer.getName());
        existing.setUsername(customer.getUsername());
        existing.setPassword(customer.getPassword());
        existing.setEmail(customer.getEmail());

        customerRepository.save(existing);
    }

    public List<Customer> getCustomerByName(String name) {
        return customerRepository.getCustomerByName(name);
    }
    public List<Customer> getCustomerByUsername(String username) {
        return customerRepository.getCustomerByUsername(username);
    }

    public List<Customer> getCustomerByGradeLevel(String gradeLevel) {
        return customerRepository.getCustomerByGradeLevel(gradeLevel);
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
