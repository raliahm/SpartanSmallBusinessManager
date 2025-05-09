package com.SpartanSmallBusinessManager.API.business;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Integer> {
    Business findByProvider(Provider provider);
}


