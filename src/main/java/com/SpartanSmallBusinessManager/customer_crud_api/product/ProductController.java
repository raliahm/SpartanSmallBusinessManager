package com.SpartanSmallBusinessManager.API.product;

import com.SpartanSmallBusinessManager.API.business.Business;
import com.SpartanSmallBusinessManager.API.business.BusinessService;
import com.SpartanSmallBusinessManager.API.provider.Provider;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BusinessService businessService;

    // Display the products page
    @GetMapping
    public String showProducts(Model model, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) {
            return "redirect:/login";
        }

        List<Product> products = productService.getAllProductsForProvider(provider);
        Business business = businessService.getBusinessByProvider(provider);

        model.addAttribute("products", products);
        model.addAttribute("business", business);

        return "product";
    }

    // Create a new product (manually bind fields to avoid 400)
    @PostMapping("/create")
    public String createProduct(@RequestParam("productName") String name,
                                @RequestParam("productDescription") String description,
                                @RequestParam("productPrice") double price,
                                @RequestParam("productQuantity") int quantity,
                                @RequestParam("productCategory") String category,
                                @RequestParam("productImageFile") MultipartFile imageFile,
                                HttpSession session) throws IOException {

        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Business business = businessService.getBusinessByProvider(provider);
        if (business == null) return "redirect:/business";

        Product product = new Product();
        product.setProductName(name);
        product.setProductDescription(description);
        product.setProductPrice(price);
        product.setProductQuantity(quantity);
        product.setProductCategory(category);
        product.setProvider(provider);
        product.setBusiness(business);

        productService.addNewProduct(product, imageFile);

        return "redirect:/products";
    }

    // Update existing product (manual binding)
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id,
                                @RequestParam("productName") String name,
                                @RequestParam("productDescription") String description,
                                @RequestParam("productPrice") double price,
                                @RequestParam("productQuantity") int quantity,
                                @RequestParam("productCategory") String category,
                                @RequestParam("productImageFile") MultipartFile imageFile,
                                HttpSession session) throws IOException {

        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Business business = businessService.getBusinessByProvider(provider);
        if (business == null) return "redirect:/business";

        Product updatedProduct = new Product();
        updatedProduct.setProductId(id);
        updatedProduct.setProductName(name);
        updatedProduct.setProductDescription(description);
        updatedProduct.setProductPrice(price);
        updatedProduct.setProductQuantity(quantity);
        updatedProduct.setProductCategory(category);
        updatedProduct.setProvider(provider);
        updatedProduct.setBusiness(business);

        productService.updateProduct(updatedProduct, imageFile);

        return "redirect:/products";
    }

    // Delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, HttpSession session) {
        Provider provider = (Provider) session.getAttribute("provider");
        if (provider == null) return "redirect:/login";

        Product product = productService.getProductById(id);
        if (product != null && product.getProvider().getProviderId() == provider.getProviderId()) {
            productService.deleteProductById(id);
        }

        return "redirect:/products";
    }
}
