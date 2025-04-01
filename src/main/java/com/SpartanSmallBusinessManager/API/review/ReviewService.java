package com.SpartanSmallBusinessManager.API.review;

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

    public void addNewReview(Review review) {
        reviewRepository.save(review);
    }

    public void updateReview(int reviewId, Review review) {
        Review existing = getReviewById(reviewId);
        if (existing != null) {
            existing.setReviewContent(review.getReviewContent());
            existing.setProduct(review.getProduct());
            existing.setProvider(review.getProvider());
            reviewRepository.save(existing);
        }
    }

    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
