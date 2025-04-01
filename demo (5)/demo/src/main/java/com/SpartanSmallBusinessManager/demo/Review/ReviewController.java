package com.SpartanSmallBusinessManager.demo.Review;

import com.SpartanSmallBusinessManager.demo.Business.Business;
import com.SpartanSmallBusinessManager.demo.Business.BusinessRepository;
import com.SpartanSmallBusinessManager.demo.Business.BusinessService;
import com.SpartanSmallBusinessManager.demo.Customer.Customer;
import com.SpartanSmallBusinessManager.demo.Customer.CustomerRepository;
import com.SpartanSmallBusinessManager.demo.Customer.CustomerService;
import com.SpartanSmallBusinessManager.demo.Subscription.Subscription;
import com.SpartanSmallBusinessManager.demo.Subscription.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BusinessService businessService;

    @PostMapping("/{customerId}/{businessId}")
    public Object writeReview(@RequestBody Review review){
        System.out.println(review.toString());
        reviewService.writeReview(review);
        int productReviewId = review.getBusiness().getBusinessId();
        return new ResponseEntity<>(businessService.getBusinessById(productReviewId), HttpStatus.OK);

    }

}
