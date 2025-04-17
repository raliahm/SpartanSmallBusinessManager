package com.SpartanSmallBusinessManager.customer_crud_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public Object getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public Object getProductById(@PathVariable int productId) {
        return new ResponseEntity<>(service.getProductById(productId), HttpStatus.OK);
    }
    @PostMapping("/new")
    public Object addNewProduct(@RequestBody Product product){
        service.addProduct(product);
        return new ResponseEntity<>("New product listed", HttpStatus.CREATED);
    }
    @PutMapping("/update/{productId}")
    public Object updateProduct(@PathVariable int productId, @RequestBody Product product) {
        service.updateProduct(productId, product);
        return new ResponseEntity<>(service.getProductById(productId), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{productId}")
    public Object deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }


}
