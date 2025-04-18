package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Entity.Product;
import com.csc340.spartan_manager.administration_portal.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private BusinessRepository businessRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(int productId, Product product) {
        Product existing = getProductById(productId);
        if (existing != null) {
            existing.setProductName(product.getProductName());
            existing.setProductDescription(product.getProductDescription());
            existing.setProductPrice(product.getProductPrice());
            existing.setProductQuantity(product.getProductQuantity());
            existing.setProductCategory(product.getProductCategory());
            existing.setProvider(product.getProvider());
            existing.setBusiness(product.getBusiness());
            productRepository.save(existing);
        }
    }

    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}