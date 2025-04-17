package com.SpartanSmallBusinessManager.customer_crud_api.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }
    public void addReview(Review review) {
        reviewRepository.save(review);
    }
    public void updateReview(Review review, int reviewId) {
        Review existing = getReviewById(reviewId);
        existing.setReviewText(review.getReviewText());
        reviewRepository.save(existing);
    }
    public void deleteReview(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
