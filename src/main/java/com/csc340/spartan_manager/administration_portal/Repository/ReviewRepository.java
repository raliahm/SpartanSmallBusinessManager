package com.csc340.spartan_manager.administration_portal.Repository;


import com.csc340.spartan_manager.administration_portal.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}