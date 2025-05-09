package com.SpartanSmallBusinessManager.API.review;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByProvider(Provider provider);
}
