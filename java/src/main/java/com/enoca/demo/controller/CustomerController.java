package com.enoca.demo.controller;

import java.util.List;

import com.enoca.demo.model.Customer;
import com.enoca.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer customer(@PathVariable Long id) {

        return customerService.findById(id);
    }
    
    @PutMapping(value="/edit/{id}")
    @ResponseBody
    public Customer editcustomer(@PathVariable Long id,@RequestBody Customer customer) {
        
        return customerService.editById(id,customer);
    }

    @GetMapping("/customer")
    public List<Customer> listcustomer() {
        return customerService.findAll();
    }

    @PostMapping(path="/customer", 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer addcustomer(@RequestBody Customer customer) {
        // System.out.println(customer);
        customerService.customerSave(customer);
        return customer;
    }
    @DeleteMapping("/customer/{id}")
    public void deletecustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }
    @RequestMapping(value="/customers",method=RequestMethod.GET)
	public String customersList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
	}
}
