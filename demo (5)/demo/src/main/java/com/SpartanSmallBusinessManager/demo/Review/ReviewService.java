package com.SpartanSmallBusinessManager.demo.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void writeReview(Review review) {
        reviewRepository.save(review);
    }
}
