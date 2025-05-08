package com.csc340.spartan_manager.administration_portal.Repository;


import com.csc340.spartan_manager.administration_portal.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByFlaggedTrue();

    int countByFlaggedTrue();

    int countByFlaggedFalse();


    @Query("SELECT COUNT(r) FROM Review r")
    int countReviews();
}