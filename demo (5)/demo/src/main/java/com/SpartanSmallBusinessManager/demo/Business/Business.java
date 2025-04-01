package com.SpartanSmallBusinessManager.demo.Business;
import com.SpartanSmallBusinessManager.demo.Review.Review;
import com.SpartanSmallBusinessManager.demo.Subscription.Subscription;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="businesses")
public class Business {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int businessId;

    @Column(nullable = false)
    private String businessName;


    public Business() {}

    public Business(int businessId, String businessName) {
        this.businessId = businessId;
        this.businessName = businessName;
    }

    public Business(String businessName) {
        this.businessName = businessName;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


    public String toString(){
        return "Business{" +
                businessId +
                ", Business Name: " +
                businessName +
                '}';
    }

}
