package com.SpartanSmallBusinessManager.customer_crud_api.Review;

import com.SpartanSmallBusinessManager.customer_crud_api.Business.Business;
import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reviewId;

    @Column
    private String reviewText;



    public Review() {}

    public Review(int reviewId, int reviewText) {
        this.reviewId = reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public String getReviewText() {
        return reviewText;
    }
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }






}
