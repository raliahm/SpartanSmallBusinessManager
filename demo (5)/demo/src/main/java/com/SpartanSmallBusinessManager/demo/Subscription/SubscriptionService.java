package com.SpartanSmallBusinessManager.demo.Subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void subscribeToBusiness(Subscription subscription) {

        subscriptionRepository.save(subscription);
    }

    public void createSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }
}
