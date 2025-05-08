package com.SpartanSmallBusinessManager.customer_crud_api.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/all")
    public Object getAllReviews() {
        return new ResponseEntity<>(service.getAllReviews(), HttpStatus.OK);
    }
    @GetMapping("/{reviewId}")
    public Object getReviewById(@PathVariable int reviewId) {
        return new ResponseEntity<>(service.getReviewById(reviewId), HttpStatus.OK);
    }
    //@PostMapping("/new")
    //public Object addReview(@RequestBody Review review) {
        //service.addReview(review);
        //return new ResponseEntity<>("Review successfully posted.", HttpStatus.OK);
   // }
    @PutMapping("/update/{reviewId}")
    public Object updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        service.updateReview(review, reviewId);
        return new ResponseEntity<>("Review successfully updated.", HttpStatus.OK);
    }
    @DeleteMapping("/delete/{reviewId}")
    public Object deleteReview(@PathVariable int reviewId) {
        service.deleteReview(reviewId);
        return new ResponseEntity<>("Review successfully deleted.", HttpStatus.OK);
    }
    @PostMapping("/new")
    public String createReview(@RequestParam int customerId,
                               @RequestParam int businessId,
                               @RequestParam(name ="comment") String reviewText, RedirectAttributes redirectAttributes) {
        try{
            service.createReview(customerId, businessId, reviewText);
            redirectAttributes.addFlashAttribute("message", "Review successfully created.");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error", "Error submitting review," + e.getMessage());
        }
        return "redirect:/businesses/details/" + businessId;
    }

}
