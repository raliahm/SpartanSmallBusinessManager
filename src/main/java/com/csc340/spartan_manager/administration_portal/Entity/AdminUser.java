package com.csc340.spartan_manager.administration_portal.Entity;


import com.csc340.spartan_manager.administration_portal.User;
import com.csc340.spartan_manager.administration_portal.UserRole;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "admin_users")
public class AdminUser implements User {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String adminName;
    private String adminPassword;
    private String adminEmail;
    private String adminPhone;
    private Date adminBirthday;

    @Column(unique = true, nullable = false)  // Ensure unique username
    private String adminUsername;
    @Column(unique = true, nullable = false)
    private Timestamp createdDate;

    private final UserRole role=UserRole.ADMIN;

    public AdminUser() {

    }

    public AdminUser(String adminName, String adminPassword, String adminEmail, String adminPhone, Date adminBirthday, String adminUsername, Timestamp createdDate) {

        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
        this.adminBirthday = adminBirthday;
        this.adminUsername = adminUsername;
        this.createdDate = createdDate;
    }

    @Override
    public Timestamp getCreatedAt() {
        return createdDate;
    }

    @Override
    public void setCreatedAt(Timestamp createdAt) {
        this.createdDate = createdAt;
    }

    @Override
    public String getUserType() {
        return role.name();
    }

    @Override
    public void setUsername(String username) {
        this.adminUsername = username;
    }

    @Override
    public String getUsername() {
        return adminUsername;
    }

    @Override
    public void setUserType(String userType) {

    }

    @Override
    public String getPassword() {
        return adminPassword;
    }

    @Override
    public void setPassword(String password) {
        this.adminPassword = password;
    }

    @Override
    public String getEmail() {
        return adminEmail;
    }

    @Override
    public void setEmail(String email) {
        this.adminEmail = email;
    }

    @Override
    public String getPhoneNumber() {
        return adminPhone;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.adminPhone = phoneNumber;
    }

    @Override
    public String getFullName() {
        return adminName;
    }

    @Override
    public void setFullName(String fullName) {
        adminName = fullName;
    }

    public void setId(Long id) {
        this.adminId = id;
    }

    public Long getId() {
        return adminId;
    }

    public Date getAdminBirthday() {
        return adminBirthday;
    }

    public void setAdminBirthday(Date adminBirthday) {
        this.adminBirthday = adminBirthday;
    }
}
