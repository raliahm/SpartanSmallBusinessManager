package com.SpartanSmallBusinessManager.demo.Subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    @Query(value = "select * from subscriptions s where s.customerId = ?1" , nativeQuery = true)
    List<Subscription> findByCustomerId(int customerId);
}
