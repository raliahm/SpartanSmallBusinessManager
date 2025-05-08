package com.SpartanSmallBusinessManager.customer_crud_api.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }
    public List<Product> getProductsByBusinessId(int businessId) {
        return productRepository.findByBusinessId(businessId);
    }
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    public void updateProduct(int productId, Product product) {
        Product existing = getProductById(productId);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        productRepository.save(existing);

    }
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);

    }
}
