package com.csc340.spartan_manager.administration_portal.Repository;

import com.csc340.spartan_manager.administration_portal.Entity.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerUserRepository extends JpaRepository<CustomerUser, Long> {
     CustomerUser findByCustUsername(String custUsername);

    @Query(value= "select * from cust_users c where c.custId >= ?1", nativeQuery = true)
     List<CustomerUser> findByCustId(Long custId);
}
