package com.csc340.spartan_manager.administration_portal.Entity;


import jakarta.persistence.*;
import java.util.List;

import java.sql.Timestamp;

@Entity
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int business_id;

    @Column(nullable = false)
    private String business_name;

    @Column(nullable = false)

    private String business_description;

    private String status;

    @Column
    private String category;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ProviderUser provider;



    private boolean restricted;

    private String business_address;

//    @OneToMany(mappedBy = "business")
//    private List<UsageDetails> usageDetails;

    public Business() {
    }

    public Business(String businessName, String businessDescription, ProviderUser provider) {
        this.business_name = businessName;
        this.business_description = businessDescription;
        this.provider = provider;
    }

    public Business(String businessName, String businessDescription, String status, String category, ProviderUser provider, boolean restricted, String business_address) {
        this.business_name = businessName;
        this.business_description = businessDescription;
        this.status = status;
        this.category = category;
        this.provider = provider;
        this.restricted = restricted;

    }
    public int getBusinessId() {
        return business_id;
    }

    public void setBusinessId(int businessId) {
        this.business_id = businessId;
    }

    public String getBusinessName() {
        return business_name;
    }

    public void setBusinessName(String businessName) {
        this.business_name = businessName;
    }

    public String getBusinessDescription() {
        return business_description;
    }

    public void setBusinessDescription(String businessDescription) {
        this.business_description = businessDescription;
    }

    public ProviderUser getProvider() {
        return provider;
    }

    public void setProvider(ProviderUser provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    public boolean isRestricted() {
        return restricted;
    }
    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public String getBusinessAddress() {
        return business_address;
    }
    public void setBusinessAddress(String businessAddress) {
        this.business_address = businessAddress;
    }



}