package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.DTO.ReviewDTO;
import com.csc340.spartan_manager.administration_portal.Entity.Review;
import com.csc340.spartan_manager.administration_portal.Repository.BadWordRepository;
import com.csc340.spartan_manager.administration_portal.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private BadWordRepository badWordRepository;

    @Autowired
    private EntityUpdateEntryService updateLogger;


    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll(); // Assuming you have a repo
        return reviews.stream().map(review -> new ReviewDTO(
                review.getReviewId(),
                review.getReviewContent(),
                review.getProvider().getFullName() ,// or getUsername(), getFullName(), etc.
                review.getCustomer().getCustName(),
                review.getProduct().getProductName(),
                review.getCreatedAt()
        )).collect(Collectors.toList());
    }


    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    public void addNewReview(Review review) {
        if (containsBadWords(review.getReviewContent())) {
            review.setFlagged(true);
        }
        reviewRepository.save(review);
        updateLogger.logUpdate(review.getReviewId(), "INSERT", "reviews", "", "", "", "Created review");
    }

    public void updateReview(int reviewId, Review review) {
        Review existing = getReviewById(reviewId);

        if (existing != null) {
            if (!existing.getReviewContent().equals(review.getReviewContent())) {
                updateLogger.logUpdate(reviewId, "UPDATE", "reviews", "reviewContent",
                        existing.getReviewContent(), review.getReviewContent(), "Updated review content");
            }

            if (containsBadWords(review.getReviewContent())) {
                existing.setFlagged(true);
            }

            existing.setReviewContent(review.getReviewContent());
            existing.setProduct(review.getProduct());
            existing.setProvider(review.getProvider());

            reviewRepository.save(existing);
        }
    }


    private boolean containsBadWords(String content) {
        if (content == null) return false;
        String lowerCaseContent = content.toLowerCase();
        List<String> badWords = badWordRepository.findAll().stream()
                .map(bw -> bw.getWord().toLowerCase())
                .toList();
        return badWords.stream().anyMatch(lowerCaseContent::contains);
    }

    public void deleteReviewById(int reviewId) {
        updateLogger.logUpdate(reviewId, "DELETE", "reviews", "", "", "", "Deleted review");
        reviewRepository.deleteById(reviewId);
    }

    public List<ReviewDTO> getFlaggedReviews() {
        return reviewRepository.findByFlaggedTrue().stream().map(review -> new ReviewDTO(
                review.getReviewId(),
                review.getCustomer().getCustName(),
                review.getProvider().getFullName(),
                review.getProduct().getProductName(),
                review.getReviewContent(),
                review.getCreatedAt()
        )).collect(Collectors.toList());
    }

}