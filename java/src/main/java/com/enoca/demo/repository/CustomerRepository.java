package com.enoca.demo.repository;


import java.util.List;

import com.enoca.demo.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   @Query(value = "Select * FROM customers LEFT JOIN orders ON orders.customer_id=customers.id",
   nativeQuery = true)
   List<Customer> getAllListWithOrders();
}