package com.csc340.spartan_manager.administration_portal.DTO;

public class BusinessDTO {
    private String business_name;
    private String business_address;
    private String business_description;
    private String category;
    private int provider_id;

    // Getters and setters
    public BusinessDTO() {

    }
    public BusinessDTO(String business_name, String business_address, String business_description, String category, int provider_id) {
        this.business_name = business_name;
        this.business_address = business_address;
        this.business_description = business_description;
        this.category = category;
        this.provider_id = provider_id;
    }
    public String getBusiness_name() {
        return business_name;
    }
    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }
    public String getBusiness_address() {
        return business_address;
    }
    public void setBusiness_address(String business_address) {
        this.business_address = business_address;
    }
    public String getBusiness_description() {
        return business_description;
    }
    public void setBusiness_description(String business_description) {
        this.business_description = business_description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getProvider_id() {
        return provider_id;
    }
    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }
}
