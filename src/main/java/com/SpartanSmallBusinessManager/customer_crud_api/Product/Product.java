package com.SpartanSmallBusinessManager.customer_crud_api.Product;

import com.SpartanSmallBusinessManager.customer_crud_api.Business.Business;
import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable=false)
    private double price;

    @Column(nullable=false)
    private int quantity = 0;

    @ManyToOne
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;


    public Product() {}

    public Product(int productId, String name, String description, int price, Business business, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.business = business;
        this.quantity = quantity;
    }

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Business getBusiness() {
        return business;
    }
    public void setBusiness(Business business) {
        this.business = business;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
