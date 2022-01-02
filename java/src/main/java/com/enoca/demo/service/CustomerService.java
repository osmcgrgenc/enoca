package com.enoca.demo.service;

import java.util.List;
import java.util.Optional;

import com.enoca.demo.model.Customer;
import com.enoca.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public void customerSave(Customer customer) {

        customerRepository.save(customer);
    }
    
    public List<Customer> findAll() {
        return customerRepository.getAllListWithOrders();
    }

    public Customer editById(Long id, Customer customer) {
        Customer editCustomer = customerRepository.getById(id);
        if (customer.getFirstName() != null) {
            editCustomer.setFirstName(customer.getFirstName());

        }
        if (customer.getLastName()!=null) {
            editCustomer.setLastName(customer.getLastName());

        }
        if (customer.getAge()>0) {
            editCustomer.setAge(customer.getAge());
        }
        return customerRepository.save(editCustomer);
    }

    public Customer findById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.get();
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id); 
    }
}
