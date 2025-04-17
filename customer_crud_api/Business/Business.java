package com.SpartanSmallBusinessManager.customer_crud_api.Business;

import com.SpartanSmallBusinessManager.customer_crud_api.Customer.Customer;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="businesses")
public class Business {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int businessId;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;


    public Business() {}

    public Business(int businessId, String name, String description) {
        this.businessId = businessId;
        this.name = name;
        this.description = description;

    }
    public Business(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getBusinessId() {
        return businessId;
    }
    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
    public String getBusinessName() {
        return name;
    }
    public void setBusinessName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



}
