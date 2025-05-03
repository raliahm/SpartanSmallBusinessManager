package com.csc340.spartan_manager.administration_portal.Entity;


import com.csc340.spartan_manager.administration_portal.User;
import com.csc340.spartan_manager.administration_portal.UserRole;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "customers")
public class CustomerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String custName;
    private String custEmail;
    private String custPhone;
    private String custAddress;
    private String custCity;
    private String custState;
    private String custCountry;
    private String custZip;
    @Column(unique=true, nullable=false)
    private String custUsername;
    private String custPassword;
    private Timestamp createdDate;
    private boolean restricted = false;
    private String state;
    private final UserRole role = UserRole.CUSTOMER;

    public CustomerUser() {

    }
    public CustomerUser(String custName, String custAddress, String custUsername, String custPassword, String custEmail, Timestamp custCreated) {
        this.custName = custName;
        this.custAddress = custAddress;
        this.custUsername = custUsername;
        this.custPassword = custPassword;
        this.custEmail = custEmail;
        this.createdDate = custCreated;
        this.state = "Pending";
    }

    public CustomerUser(String custName, String custEmail, String custPhone, String custAddress, String custCity, String custState, String custCountry, String custZip, String custUsername, String custPassword, Timestamp custCreated) {

        this.custName = custName;
        this.custEmail = custEmail;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.custCity = custCity;
        this.custState = custState;
        this.custCountry = custCountry;
        this.custZip = custZip;
        this.custUsername = custUsername;
        this.custPassword = custPassword;
        this.createdDate = custCreated;
        this.state = "Pending";
    }

    public Timestamp getCreatedAt() {
        return createdDate;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdDate = createdAt;
    }

    public String getUserType() {
        return role.name();
    }



    public void setUserType(String userType) {

    }

    public String getPassword() {
        return custPassword;
    }

    public void setPassword(String password) {
        this.custPassword = password;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }


    public void setCustPhone(String phoneNumber) {
        this.custPhone = phoneNumber;
    }


    public void setCustName(String fullName) {
        this.custName = fullName;
    }


    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }


    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }


    public void setCustState(String custState) {
        this.custState = custState;
    }


    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public boolean isRestricted() {
        return restricted;
    }
    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public String getCustUsername() {
        return custUsername;
    }

    public void setCustUsername(String custUsername) {
        this.custUsername = custUsername;
    }



    public String getCustName() {
        return custName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public String getCustCity() {
        return custCity;
    }

    public String getCustState() {
        return custState;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public UserRole getRole() {
        return role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
