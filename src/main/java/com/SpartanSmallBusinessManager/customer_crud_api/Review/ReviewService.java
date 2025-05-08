package com.SpartanSmallBusinessManager.customer_crud_api.Review;

import com.SpartanSmallBusinessManager.customer_crud_api.Business.Business;
import com.SpartanSmallBusinessManager.customer_crud_api.Business.BusinessRepository;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BusinessRepository businessRepository;

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

    public List<Review> getReviewsForBusiness(int businessId) {
        return reviewRepository.findByBusiness_BusinessId(businessId);
    }
    public void createReview(int customerId, int businessId, String reviewText) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Business business = businessRepository.findById(businessId).orElse(null);

        if (customer != null && business != null) {
            Review review = new Review();
            review.setCustomer(customer);
            review.setBusiness(business);
            review.setReviewText(reviewText);
            reviewRepository.save(review);
        }
    }

}
