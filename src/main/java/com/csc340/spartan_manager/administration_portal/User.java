package com.csc340.spartan_manager.administration_portal;

import java.sql.Date;

public interface User {
    Date getCreatedAt();
    void setCreatedAt(Date createdAt);
    String getUserType();
    void setUsername(String username);
    String getUsername();
    void setUserType(String userType);
    String getPassword();
    void setPassword(String password);
    String getEmail();
    void setEmail(String email);
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);
    String getFullName();
    void setFullName(String fullName);

}
