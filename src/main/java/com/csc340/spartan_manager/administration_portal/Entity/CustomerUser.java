package com.csc340.spartan_manager.administration_portal.Entity;


import com.csc340.spartan_manager.administration_portal.User;
import com.csc340.spartan_manager.administration_portal.UserRole;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cust_users")
public class CustomerUser implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;
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
    private Date custCreated;

    private final UserRole role = UserRole.CUSTOMER;

    public CustomerUser() {

    }
    public CustomerUser(String custName, String custAddress, String custUsername, String custPassword, String custEmail, Date custCreated) {
        this.custName = custName;
        this.custAddress = custAddress;
        this.custUsername = custUsername;
        this.custPassword = custPassword;
        this.custEmail = custEmail;
        this.custCreated = custCreated;
    }

    public CustomerUser(String custName, String custEmail, String custPhone, String custAddress, String custCity, String custState, String custCountry, String custZip, String custUsername, String custPassword, Date custCreated) {

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
        this.custCreated = custCreated;
    }

    @Override
    public Date getCreatedAt() {
        return custCreated;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.custCreated = createdAt;
    }

    @Override
    public String getUserType() {
        return role.name();
    }

    @Override
    public void setUsername(String username) {
        this.custUsername = username;
    }

    @Override
    public String getUsername() {
        return custUsername;
    }

    @Override
    public void setUserType(String userType) {

    }

    @Override
    public String getPassword() {
        return custPassword;
    }

    @Override
    public void setPassword(String password) {
        this.custPassword = password;
    }

    @Override
    public String getEmail() {
        return custEmail;
    }

    @Override
    public void setEmail(String email) {
        this.custEmail = email;
    }

    @Override
    public String getPhoneNumber() {
        return custPhone;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.custPhone = phoneNumber;
    }

    @Override
    public String getFullName() {
        return custName;
    }

    @Override
    public void setFullName(String fullName) {
        this.custName = fullName;
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

    public String getCustCountry() {
        return custCountry;
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

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }
}
