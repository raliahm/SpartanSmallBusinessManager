package com.csc340.spartan_manager.administration_portal.DTO;


import java.sql.Timestamp;

public class ReviewDTO {
    private int reviewId;
    private String reviewContent;
    private String providerName;
    private String customerName;
    private String productName;
    private Timestamp createdDate;

    // Constructors
    public ReviewDTO(int reviewId, String reviewContent, String providerName,
                     String customerName, String productName, Timestamp createdDate) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.providerName = providerName;
        this.customerName = customerName;
        this.productName = productName;
        this.createdDate = createdDate;
    }

    // Getters and Setters
    // ...

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
