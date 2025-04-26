package com.csc340.spartan_manager.administration_portal.DTO;
public class CustomerDTO {

    private String custUsername;
    private String custPassword;
    private String custName;
    private String custEmail;
    private String custPhone;
    private String custAddress;
    private String custCity;
    private String custZip;
    private String custState;
    private String custCountry;

    // Constructors
    public CustomerDTO() {
    }

    public CustomerDTO(String custUsername, String custPassword, String custName, String custEmail,
                       String custPhone, String custAddress, String custCity, String custZip, String custState,  String custCountry) {
        this.custUsername = custUsername;
        this.custPassword = custPassword;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.custCity = custCity;
        this.custZip = custZip;
        this.custState = custState;
        this.custCountry = custCountry;
    }

    // Getters and Setters
    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState;
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    public String getCustCountry() {
        return custCountry;
    }
    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }
}