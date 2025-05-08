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

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;



    public Review() {}

    public Review(int reviewId, int reviewText) {
        this.reviewId = reviewId;
    }

    public Review(int reviewId, String reviewText, Customer customer, Business business) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.customer = customer;
        this.business = business;
    }

    public Review(String reviewText, Customer customer, Business business) {
        this.reviewText = reviewText;
        this.customer = customer;
        this.business = business;
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
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Business getBusiness() {
        return business;
    }
    public void setBusiness(Business business) {
        this.business = business;
    }






}
