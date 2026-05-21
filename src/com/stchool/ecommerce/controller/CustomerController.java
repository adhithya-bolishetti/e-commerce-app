package com.stchool.ecommerce.controller;

import com.stchool.ecommerce.exception.CustomerExistsException;
import com.stchool.ecommerce.exception.InvalidCredentialsException;
import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.service.CustomerService;
import com.stchool.ecommerce.service.CustomerServiceImpl;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer save(Customer customer) throws CustomerExistsException {
        return customerService.save(customer);
    }

    public Customer login(String email, String password) throws CustomerExistsException, InvalidCredentialsException {
        return customerService.login(email, password);
    }
}
