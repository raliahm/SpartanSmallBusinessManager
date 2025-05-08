package com.SpartanSmallBusinessManager.customer_crud_api.Business;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.Product;
import com.SpartanSmallBusinessManager.customer_crud_api.Product.ProductService;
import com.SpartanSmallBusinessManager.customer_crud_api.Review.Review;
import com.SpartanSmallBusinessManager.customer_crud_api.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService service;
    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewService reviewService;

    /**
     * Gets list of all businesses.
     * http://localhost:8080/businesses/all
     * @return
     */
    @GetMapping("/all")
    public String getAllBusinesses(Model model){
        model.addAttribute("businesses", service.getAllBusinesses());
        model.addAttribute("title", "All Businesses");
        return "home";
        //return new ResponseEntity<>(service.getAllBusinesses(), HttpStatus.OK);
    }
    @GetMapping("/search")
    public String searchBusiness(@RequestParam(name = "q", required = false) String query, Model model) {
        if (query == null || query.isBlank()) {
            model.addAttribute("businesses", service.getAllBusinesses());
        } else {
            model.addAttribute("businesses", service.getBusinessesByName(query));
        }
        model.addAttribute("title", "Business Search");
        return "home";
    }


    @GetMapping("/createForm")
    public String createForm(Model model){
        model.addAttribute("business", new Business());
        return "business/business-form";
    }

    /**
     * Creates a new business.
     * http://localhost:8080/businesses/new
     * @param business
     * @return
     */
    @PostMapping("/new")
    public String addNewBusiness(@ModelAttribute Business business){
        service.addNewBusiness(business);
        return "redirect:/businesses/all";
    }

    @GetMapping("/update/{businessId}")
    public String updateBusinessForm(@PathVariable int businessId, Model model) {
        Business existing = service.getBusinessById(businessId);
        model.addAttribute("business", existing);
        return "business/business-form";
    }

    /**
     * Updates Business information.
     * http://localhost:8080/businesses/update/2
     * @param business
     * @param businessId
     * @return
     */
    @PostMapping("/update/{businessId}")
    public String updateBusiness(@ModelAttribute Business business, @PathVariable int businessId){
        business.setBusinessId(businessId);
        service.updateBusiness(businessId, business);
        return "redirect:/businesses/all";
    }

    /**
     * Deletes business from the table.
     * http://localhost:8080/businesses/delete/2
     * @param businessId
     * @return
     */
    @DeleteMapping("/delete/{businessId}")
    public String deleteBusiness(@PathVariable int businessId){
        service.deleteBusiness(businessId);
        return "redirect:/businesses/all";
    }
    @GetMapping("/details/{businessId}")
    public String viewBusinessDetail(@PathVariable int businessId, Model model) {
        Business business = service.getBusinessById(businessId);
        List<Product> products = productService.getProductsByBusinessId(businessId);
        List<Review> reviews = reviewService.getReviewsForBusiness(businessId);

        model.addAttribute("business", business);
        model.addAttribute("products", products);
        model.addAttribute("reviews", reviews);

        return "business/business-detail";
    }





}
