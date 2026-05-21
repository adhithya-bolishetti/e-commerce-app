package com.stchool.ecommerce.ui;

import com.stchool.ecommerce.controller.CustomerController;
import com.stchool.ecommerce.exception.CustomerExistsException;
import com.stchool.ecommerce.exception.CustomerNotFoundException;
import com.stchool.ecommerce.exception.InvalidCredentialsException;
import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.util.InputUtil;

import java.util.Scanner;

public class CustomerUI {
    private final CustomerController customerController;

    public CustomerUI(CustomerController customerController) {
        this.customerController = customerController;
    }

    public Customer registerCustomer() throws CustomerExistsException {
        System.out.println("Customer Registration Form");
        System.out.print("Enter Id: ");
        int id = InputUtil.getIntInput("Enter Id: ");
        String name = InputUtil.getStringInput("Enter Name: ");
        String email = InputUtil.getStringInput("Enter E-mail: ");
        String password = InputUtil.getStringInput("Enter Password: ");
        String contactNo = InputUtil.getStringInput("Enter Contact Number: ");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setContactNo(contactNo);
        customer.setPassword(password);

        return customerController.save(customer);
    }

    public Customer loginCustomer() throws CustomerNotFoundException, InvalidCredentialsException {
        String email = InputUtil.getStringInput("Enter E-mail: ");
        String password = InputUtil.getStringInput("Enter Password: ");

        return customerController.login(email, password);
    }
}
