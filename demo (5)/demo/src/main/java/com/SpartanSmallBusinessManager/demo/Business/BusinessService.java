package com.SpartanSmallBusinessManager.demo.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusinesses() {

        return businessRepository.findAll();
    }

    public Business getBusinessById(int businessId) {
        return businessRepository.findById(businessId).orElse(null);
    }

}
