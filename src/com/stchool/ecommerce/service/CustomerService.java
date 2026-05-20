package com.stchool.ecommerce.service;

import com.stchool.ecommerce.exception.CustomerExistsException;
import com.stchool.ecommerce.exception.CustomerNotFoundException;
import com.stchool.ecommerce.exception.InvalidCredentialsException;
import com.stchool.ecommerce.model.Customer;

public interface CustomerService {
    Customer save(Customer customer) throws CustomerExistsException;
    Customer login(String email, String password) throws CustomerNotFoundException, InvalidCredentialsException;
}
