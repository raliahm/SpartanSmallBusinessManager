package com.SpartanSmallBusinessManager.demo.Subscription;
import com.SpartanSmallBusinessManager.demo.Business.Business;
import com.SpartanSmallBusinessManager.demo.Customer.Customer;
import jakarta.persistence.*;


@Entity
@Table(name="subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionId;

    @ManyToOne
    @JoinColumn(name= "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "businessId", nullable = false)
    private Business business;

    @Column(nullable = false)
    private String status;

    public Subscription() {}

    public Subscription(Customer customer, Business business, String status) {
        this.customer = customer;
        this.business = business;
        this.status = status;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Business getBusiness() {
        return business;
    }

    public String toString() {
        return "Subscriptions{" + "subscriptionId=" +
                subscriptionId +
                ", Business=" +
                business +
                ", Customer=" +
                customer +
                ", status=" +
                status +
                '}';
    }



}
