package com.csc340.spartan_manager.administration_portal.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ProviderUser provider;

    public Review() {
    }

    public Review(String reviewContent, Product product, ProviderUser provider) {
        this.reviewContent = reviewContent;
        this.product = product;
        this.provider = provider;
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProviderUser getProvider() {
        return provider;
    }

    public void setProvider(ProviderUser provider) {
        this.provider = provider;
    }
}