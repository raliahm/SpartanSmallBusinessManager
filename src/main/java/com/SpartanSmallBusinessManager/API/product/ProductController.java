package com.SpartanSmallBusinessManager.API.product;

import com.SpartanSmallBusinessManager.API.business.BusinessRepository;
import com.SpartanSmallBusinessManager.API.provider.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ProductController.java.
 * Includes all REST API endpoint mappings for the Product object.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private BusinessRepository businessRepository;

    /**
     * Get a list of all Products in the database.
     * http://localhost:8080/products/all
     *
     * @return a list of Product objects.
     */
    @GetMapping("/all")
    public Object getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    /**
     * Create a new Product entry.
     * http://localhost:8080/products/new
     *
     * @param product the new Product object.
     * @return confirmation message.
     */
    @PostMapping("/new")
    public Object addNewProduct(@RequestBody Product product) {
        service.addNewProduct(product);
        return new ResponseEntity<>("New Product Successfully Created!", HttpStatus.CREATED);
    }

    /**
     * Update an existing Product object.
     * http://localhost:8080/products/update/2
     *
     * @param productId the unique Product Id.
     * @param product   the updated Product details.
     * @return the updated Product object.
     */
    @PutMapping("/update/{productId}")
    public Object updateProduct(@PathVariable int productId, @RequestBody Product product) {
        service.updateProduct(productId, product);
        return new ResponseEntity<>(service.getProductById(productId), HttpStatus.CREATED);
    }

    /**
     * Delete a Product object.
     * http://localhost:8080/products/delete/2
     *
     * @param productId the unique Product Id.
     * @return the updated list of Products.
     */
    @DeleteMapping("/delete/{productId}")
    public Object deleteProductById(@PathVariable int productId) {
        service.deleteProductById(productId);
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }
}
