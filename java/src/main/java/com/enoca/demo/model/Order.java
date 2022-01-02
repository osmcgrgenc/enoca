package com.enoca.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;
    
    @ManyToOne
    private Customer customer;

    protected Order() {
    }

    public Order( Customer customer) {
        
        this.customer = customer;
    }

    
    public Long getId() {
        return this.order_id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}