package com.csc340.spartan_manager.administration_portal.Entity;


import com.csc340.spartan_manager.administration_portal.User;
import com.csc340.spartan_manager.administration_portal.UserRole;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


import java.sql.Date;


@Entity
@Table(name = "provider_users")
public class ProviderUser implements User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @Column(unique = true, nullable = false)  // Ensure unique username
    private String providerUsername;

    private String providerUserPassword;
    private String providerUserEmail;
    private String providerUserPhone;

    private String providerUserAddress;
    private String providerUserCity;
    private String providerUserState;
    private String providerUserCountry;
    private String providerUserZip;
    private Date createdDate;
    private String providerName;



    @Enumerated(EnumType.STRING)
    private final UserRole role = UserRole.PROVIDER;


    public ProviderUser() {
    }

    public ProviderUser(String providerUserName, String providerUserPassword, String providerUserEmail, String providerUserPhone, String providerUserAddress, String providerUserCity, String providerUserState, String providerUserCountry, String providerUserZip, Date createdDate, String providerName) {

        this.providerUsername = providerUserName;
        this.providerUserPassword = providerUserPassword;
        this.providerUserEmail = providerUserEmail;
        this.providerUserPhone = providerUserPhone;
        this.providerUserAddress = providerUserAddress;
        this.providerUserCity = providerUserCity;
        this.providerUserState = providerUserState;
        this.providerUserCountry = providerUserCountry;
        this.providerUserZip = providerUserZip;
        this.createdDate = createdDate;
        this.providerName = providerName;
    }

    public ProviderUser(String providerUserName, String providerUserPassword, String providerUserEmail, String providerUserPhone, String providerUserAddress, String providerName) {
        this.providerUsername = providerUserName;
        this.providerUserPassword = providerUserPassword;
        this.providerUserEmail = providerUserEmail;
        this.providerUserPhone = providerUserPhone;
        this.providerUserAddress = providerUserAddress;
        this.providerName = providerName;
    }

    @Override
    public Date getCreatedAt() {
        return createdDate;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdDate = createdAt;
    }

    @Override
    public String getUserType() {
        return role.name();
    }

    @Override
    public void setUsername(String username) {
        this.providerUsername = username;
    }

    @Override
    public String getUsername() {
        return providerUsername;
    }

    @Override
    public void setUserType(String userType) {

    }


    @Override
    public String getPassword() {
        return providerUserPassword;
    }

    @Override
    public void setPassword(String password) {
        this.providerUserPassword = password;
    }

    @Override
    public String getEmail() {
        return providerUserEmail;
    }

    @Override
    public void setEmail(String email) {
        this.providerUserEmail = email;
    }

    @Override
    public String getPhoneNumber() {
        return providerUserPhone;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.providerUserPhone = phoneNumber;
    }

    @Override
    public String getFullName() {
        return providerName;
    }

    @Override
    public void setFullName(String fullName) {
        this.providerName = fullName;
    }

    public void setProviderID(Long id) {
        this.providerId = id;
    }

    public Long getProviderID() {
        return providerId;
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

    public String getProviderUserCountry() {
        return providerUserCountry;
    }

    public void setProviderUserCountry(String providerUserCountry) {
        this.providerUserCountry = providerUserCountry;
    }

    public String getProviderUserState() {
        return providerUserState;
    }

    public void setProviderUserState(String providerUserState) {
        this.providerUserState = providerUserState;
    }

    public String getProviderUserZip() {
        return providerUserZip;
    }

    public void setProviderUserZip(String providerUserZip) {
        this.providerUserZip = providerUserZip;
    }
}
