package com.stchool.ecommerce.service;

import com.stchool.ecommerce.exception.CustomerExistsException;
import com.stchool.ecommerce.exception.CustomerNotFoundException;
import com.stchool.ecommerce.exception.InvalidCredentialsException;
import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.repository.CustomerRepository;
import com.stchool.ecommerce.util.CsvReader;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistsException {

        if (customerRepository.existsByEmail(customer.getEmail()) != null) {
            throw new CustomerExistsException("Customer already exists with email: " + customer.getEmail());
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String email, String password) throws CustomerNotFoundException, InvalidCredentialsException {

        Customer existingCustomer = customerRepository.existsByEmail(email);

        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Customer not found with email: " + email);
        }
        if (existingCustomer.getPassword().equals(password)) {
            return existingCustomer;
        } else {
            throw new InvalidCredentialsException("Invalid password");
        }
    }
}
