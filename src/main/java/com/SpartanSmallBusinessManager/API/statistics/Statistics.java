package com.SpartanSmallBusinessManager.API.statistics;

import jakarta.persistence.*;

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

    public Statistics() {
    }

    public Statistics(double totalSales, int totalReviews) {
        this.totalSales = totalSales;
        this.totalReviews = totalReviews;
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
}
