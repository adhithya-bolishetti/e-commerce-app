package com.stchool.ecommerce.service;

import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.repository.CustomerRepository;

public class CustomerService {
    public Customer handleSignup(Customer customer) {
        System.out.println("Handling Customer data in service layer of " + customer);
        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.addNewCustomer(customer);
    }
    public void displayCustomerDetails(Customer customer) {
        System.out.println("Id : " + customer.getId());
        System.out.println("FirstName : " + customer.getFirstName());
        System.out.println("LastName : " + customer.getLastName());
        System.out.println("E-Mail : " + customer.getEmail());
        System.out.println("Contact Number : " + customer.getContactNo());
    }
}
