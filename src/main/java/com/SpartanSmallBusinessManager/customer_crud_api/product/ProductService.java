package com.SpartanSmallBusinessManager.API.product;

import com.SpartanSmallBusinessManager.API.provider.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    // Save uploaded files to a real runtime-accessible folder (not src/resources!)
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uploads/";

    @Autowired
    private ProductRepository productRepository;

    // Get all products for a provider
    public List<Product> getAllProductsForProvider(Provider provider) {
        return productRepository.findByProvider(provider);
    }

    // Get a product by ID
    public Product getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // Create a new product
    public void addNewProduct(Product product, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            String imageUrl = saveImage(imageFile);
            product.setProductImage(imageUrl);
        }
        productRepository.save(product);
    }

    // Update an existing product
    public void updateProduct(Product updatedProduct, MultipartFile imageFile) throws IOException {
        Product existing = productRepository.findById(updatedProduct.getProductId()).orElse(null);
        if (existing != null) {
            existing.setProductName(updatedProduct.getProductName());
            existing.setProductDescription(updatedProduct.getProductDescription());
            existing.setProductPrice(updatedProduct.getProductPrice());
            existing.setProductQuantity(updatedProduct.getProductQuantity());
            existing.setProductCategory(updatedProduct.getProductCategory());

            if (imageFile != null && !imageFile.isEmpty()) {
                String imageUrl = saveImage(imageFile);
                existing.setProductImage(imageUrl);
            }

            productRepository.save(existing);
        }
    }

    // Delete a product
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    // Save image to a real folder and return the public-accessible path
    private String saveImage(MultipartFile imageFile) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            return null;
        }

        String originalName = imageFile.getOriginalFilename();
        if (originalName == null || !originalName.contains(".")) {
            throw new IllegalArgumentException("Invalid file name");
        }

        String extension = originalName.substring(originalName.lastIndexOf('.'));
        String fileName = UUID.randomUUID() + extension;

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File destination = new File(uploadDir, fileName);
        imageFile.transferTo(destination);

        return "/uploads/" + fileName; // Public path used in <img src="...">
    }
}
