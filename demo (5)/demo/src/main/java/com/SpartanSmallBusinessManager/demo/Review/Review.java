package com.SpartanSmallBusinessManager.demo.Review;
import com.SpartanSmallBusinessManager.demo.Business.Business;
import com.SpartanSmallBusinessManager.demo.Customer.Customer;
import jakarta.persistence.*;

@Entity
@Table(name= "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private String reviewText;

    @ManyToOne
    @JoinColumn(name= "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "businessId", nullable = false)
    Business business;

    public Review() {}

    public Review(int reviewId, String reviewText, Customer customer, Business business) {
        this.reviewId = reviewId;
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

    public String toString(){
        return "Review{" +
                "reviewId=" +
                reviewId +
                ", reviewText='" +
                reviewText +
                ", customer=" +
                customer +
                ", business=" +
                business + '}';
    }
}

