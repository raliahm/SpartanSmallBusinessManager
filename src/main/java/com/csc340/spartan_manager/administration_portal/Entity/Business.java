package com.csc340.spartan_manager.administration_portal.Entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int businessId;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String businessDescription;

    @Column(nullable = false)
    private String status;

    @Column
    private String category;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ProviderUser provider;

    @Column
    private Timestamp createdDate;

    @Column
    private Timestamp updatedDate;

    @Column
    private Timestamp deletedDate;

    @Column(columnDefinition = "false")
    private boolean restricted;

    public Business() {
    }

    public Business(String businessName, String businessDescription, ProviderUser provider) {
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
    public Timestamp getCreatedAt() {
        return createdDate;
    }

    public void setCreatedAt(Timestamp createdAt) {

        this.createdDate = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedDate;
    }
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedDate = updatedAt;
    }
    public Timestamp getDeletedAt() {
        return deletedDate;
    }
    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedDate = deletedAt;
    }
    public boolean isRestricted() {
        return restricted;
    }
    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

}