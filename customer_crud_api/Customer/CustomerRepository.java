package com.SpartanSmallBusinessManager.customer_crud_api.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> getCustomerByGradeLevel(String gradeLevel);

    @Query(value= "select * from customers c where c.name like %?1%", nativeQuery = true)
    List<Customer> getCustomerByName(String name);
    @Query(value= "select * from customers c where c.username like %?1%", nativeQuery = true)
    List<Customer> getCustomerByUsername(String username);
}
