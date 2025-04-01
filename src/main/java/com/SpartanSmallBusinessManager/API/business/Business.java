package com.SpartanSmallBusinessManager.API.business;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.persistence.*;

@Entity
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int businessId;

    @Column(nullable = false)
    private String businessName;

    private String businessDescription;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    public Business() {
    }

    public Business(String businessName, String businessDescription, Provider provider) {
        this.businessName = businessName;
        this.businessDescription = businessDescription;
        this.provider = provider;
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

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
