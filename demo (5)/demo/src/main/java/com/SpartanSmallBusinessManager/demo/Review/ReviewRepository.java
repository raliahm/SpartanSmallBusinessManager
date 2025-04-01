package com.SpartanSmallBusinessManager.demo.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value= "select * from review r where r.businessId = ?1", nativeQuery = true)
    List<Review> findBusinessById(int businessId);


}
