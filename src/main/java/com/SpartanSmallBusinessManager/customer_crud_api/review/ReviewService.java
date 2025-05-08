package com.SpartanSmallBusinessManager.API.review;

import com.SpartanSmallBusinessManager.API.provider.Provider;
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

    public List<Review> getReviewsForProvider(Provider provider) {
        return reviewRepository.findByProvider(provider);
    }

    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public void saveReply(int reviewId, String replyContent) {
        Review review = getReviewById(reviewId);
        if (review != null) {
            review.setReplyContent(replyContent);
            reviewRepository.save(review);
        }
    }

    public void deleteReply(int reviewId) {
        Review review = getReviewById(reviewId);
        if (review != null) {
            review.setReplyContent(null);
            reviewRepository.save(review);
        }
    }
}
