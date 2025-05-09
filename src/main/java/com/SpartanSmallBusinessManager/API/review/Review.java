package com.SpartanSmallBusinessManager.API.review;

import com.SpartanSmallBusinessManager.API.product.Product;
import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private String reviewContent;

    @Column(columnDefinition = "TEXT")
    private String replyContent;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    public Review() {}

    public Review(String reviewContent, Product product, Provider provider) {
        this.reviewContent = reviewContent;
        this.product = product;
        this.provider = provider;
    }

    public int getReviewId() { return reviewId; }
    public void setReviewId(int reviewId) { this.reviewId = reviewId; }

    public String getReviewContent() { return reviewContent; }
    public void setReviewContent(String reviewContent) { this.reviewContent = reviewContent; }

    public String getReplyContent() { return replyContent; }
    public void setReplyContent(String replyContent) { this.replyContent = replyContent; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Provider getProvider() { return provider; }
    public void setProvider(Provider provider) { this.provider = provider; }
}
