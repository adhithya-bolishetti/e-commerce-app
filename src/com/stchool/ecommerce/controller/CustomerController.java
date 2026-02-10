package com.stchool.ecommerce.controller;

import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.service.CustomerService;

public class CustomerController {
    public Customer handleSignup(Customer customer) {
        System.out.println("Handling Signup data of " + customer + " in Controller layer");

        CustomerService customerService = new CustomerService();
        return customerService.handleSignup(customer);
    }
}
