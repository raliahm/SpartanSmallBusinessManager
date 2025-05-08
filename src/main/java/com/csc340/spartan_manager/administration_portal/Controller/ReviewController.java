package com.csc340.spartan_manager.administration_portal.Controller;

import com.csc340.spartan_manager.administration_portal.DTO.ReviewDTO;
import com.csc340.spartan_manager.administration_portal.Entity.Review;
import com.csc340.spartan_manager.administration_portal.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ReviewController.java.
 * Includes all REST API endpoint mappings for the Review object.
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    /**
     * Get a list of all Reviews in the database.
     * http://localhost:8080/reviews/all
     *
     * @return a list of Review objects.
     */
    @GetMapping("/all")
    public Object getAllReviews() {
        return new ResponseEntity<>(service.getAllReviews(), HttpStatus.OK);
    }

    /**
     * Create a new Review entry.
     * http://localhost:8080/reviews/new
     *
     * @param review the new Review object.
     * @return success message.
     */
    @PostMapping("/new")
    public Object addNewReview(@RequestBody Review review) {
        service.addNewReview(review);
        return new ResponseEntity<>("New Review Successfully Created!", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public Object getReviewById(@PathVariable int id) {
        service.getReviewById(id);
        return new ResponseEntity<>(service.getReviewById(id), HttpStatus.OK);
    }
    /**
     * Update an existing Review object.
     * http://localhost:8080/reviews/update/2
     *
     * @param reviewId the unique Review Id.
     * @param review   the updated Review details.
     * @return the updated Review object.
     */
    @PutMapping("/update/{reviewId}")
    public Object updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        service.updateReview(reviewId, review);
        return new ResponseEntity<>(service.getReviewById(reviewId), HttpStatus.CREATED);
    }

    /**
     * Delete a Review object.
     * http://localhost:8080/reviews/delete/2
     *
     * @param reviewId the unique Review Id.
     * @return the updated list of Reviews.
     */
    @DeleteMapping("/delete/{reviewId}")
    public Object deleteReviewById(@PathVariable int reviewId) {
        service.deleteReviewById(reviewId);
        return new ResponseEntity<>(service.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping("/flagged")
    public ResponseEntity<List<ReviewDTO>> getFlaggedReviews() {
        return new ResponseEntity<>(service.getFlaggedReviews(), HttpStatus.OK);
    }

}