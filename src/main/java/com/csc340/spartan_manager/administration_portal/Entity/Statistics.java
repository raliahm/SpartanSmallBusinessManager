package com.csc340.spartan_manager.administration_portal.Entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statsId;

    @Column(nullable = false)
    private double totalSales;

    @Column(nullable = false)
    private int totalReviews;

    @Column(nullable = false)
    private String usageDetails;

    @Column(nullable = false)
    private Timestamp createdDate;

    public Statistics() {
    }

    public Statistics(double totalSales, int totalReviews, String usageDetails) {
        this.totalSales = totalSales;
        this.totalReviews = totalReviews;
        this.usageDetails = usageDetails;
    }

    public int getStatsId() {
        return statsId;
    }

    public void setStatsId(int statsId) {
        this.statsId = statsId;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }


    public Timestamp getCreatedAt() {
        return createdDate;
    }


    public void setCreatedAt(Timestamp createdAt) {
        this.createdDate = createdAt;
    }
}