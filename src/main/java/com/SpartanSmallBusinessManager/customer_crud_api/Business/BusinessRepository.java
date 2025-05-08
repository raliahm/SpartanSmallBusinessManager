package com.SpartanSmallBusinessManager.customer_crud_api.Business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {
    @Query(value ="select * from businesses b where b.name like %?1%", nativeQuery = true)
    List<Business> getBusinessesByName(String businessName);
}
