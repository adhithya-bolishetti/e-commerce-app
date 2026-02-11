package com.stchool.ecommerce.repository;

import com.stchool.ecommerce.model.Customer;

public class CustomerRepository {
    public Customer addNewCustomer(Customer customer) {
        System.out.println("New Customer Added Successfully");
        System.out.println("Handling signup data of " + customer + " in repository layer");
        return customer;
    }
}
