package com.SpartanSmallBusinessManager.customer_crud_api.Product;

import com.SpartanSmallBusinessManager.customer_crud_api.Business.Business;
import com.SpartanSmallBusinessManager.customer_crud_api.Business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private BusinessService businessService;

    @GetMapping("/all")
    public Object getAllProducts(Model model) {
        model.addAttribute("products", service.getAllProducts());
        return "product/product-list";

    }
    @GetMapping("/{productId}")
    public Object getProductById(@PathVariable int productId, Model model) {
        model.addAttribute("product", service.getProductById(productId));
        return "product/product-detail";
    }
    @GetMapping("/business/{businessId}")
    public String getProductsByBusiness(@PathVariable int businessId, Model model) {
        model.addAttribute("products", service.getProductsByBusinessId(businessId));
        return "product/product-list";
    }
    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("businesses", businessService.getAllBusinesses());
        return "product/product-form";
    }
    @PostMapping("/new")
    public String addNewProduct(@ModelAttribute Product product, @RequestParam int businessId) {
        // Get the business using businessService
        Business business = businessService.getBusinessById(businessId);
        product.setBusiness(business);
        service.addProduct(product);
        return "redirect:/businesses/details/" + businessId; // Go to that business’s page
    }
    @GetMapping("/update/{productId}")
    public String updateForm(@PathVariable int productId, Model model) {
        model.addAttribute("product", service.getProductById(productId));
        model.addAttribute("businesses", businessService.getAllBusinesses());
        return "product/product-form";
    }

    @PutMapping("/update/{productId}")
    public Object updateProduct(@PathVariable int productId, @ModelAttribute Product product) {
        service.updateProduct(productId, product);
        return "redirect:/products/all";
    }
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
        return "redirect:/products/all";
    }


}
