package com.SpartanSmallBusinessManager.customer_crud_api.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBusiness_BusinessId(int customerId);

}
