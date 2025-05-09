package com.csc340.spartan_manager.administration_portal.DTO;

import java.sql.Timestamp;

public class ProviderDTO {

    private int providerId;
    private String providerUsername;
    private String providerUserPassword;
    private String providerUserEmail;
    private String providerUserPhone;
    private String providerUserAddress;
    private String providerUserCity;
    private String providerUserState;
    private String providerUserCountry;
    private String providerUserZip;
    private Timestamp createdDate;
    private String providerName;
    private boolean restricted;
    private String state;

    public ProviderDTO() {
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getProviderUsername() {
        return providerUsername;
    }

    public void setProviderUsername(String providerUsername) {
        this.providerUsername = providerUsername;
    }

    public String getProviderUserPassword() {
        return providerUserPassword;
    }

    public void setProviderUserPassword(String providerUserPassword) {
        this.providerUserPassword = providerUserPassword;
    }

    public String getProviderUserEmail() {
        return providerUserEmail;
    }

    public void setProviderUserEmail(String providerUserEmail) {
        this.providerUserEmail = providerUserEmail;
    }

    public String getProviderUserPhone() {
        return providerUserPhone;
    }

    public void setProviderUserPhone(String providerUserPhone) {
        this.providerUserPhone = providerUserPhone;
    }

    public String getProviderUserAddress() {
        return providerUserAddress;
    }

    public void setProviderUserAddress(String providerUserAddress) {
        this.providerUserAddress = providerUserAddress;
    }

    public String getProviderUserCity() {
        return providerUserCity;
    }

    public void setProviderUserCity(String providerUserCity) {
        this.providerUserCity = providerUserCity;
    }

    public String getProviderUserState() {
        return providerUserState;
    }

    public void setProviderUserState(String providerUserState) {
        this.providerUserState = providerUserState;
    }

    public String getProviderUserCountry() {
        return providerUserCountry;
    }

    public void setProviderUserCountry(String providerUserCountry) {
        this.providerUserCountry = providerUserCountry;
    }

    public String getProviderUserZip() {
        return providerUserZip;
    }

    public void setProviderUserZip(String providerUserZip) {
        this.providerUserZip = providerUserZip;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
