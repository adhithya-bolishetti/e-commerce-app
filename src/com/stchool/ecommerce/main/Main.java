package com.stchool.ecommerce.main;

import com.stchool.ecommerce.controller.CustomerController;
import com.stchool.ecommerce.exception.CustomerExistsException;
import com.stchool.ecommerce.exception.CustomerNotFoundException;
import com.stchool.ecommerce.exception.InvalidCredentialsException;
import com.stchool.ecommerce.factory.AppFactory;
import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.ui.CustomerUI;
import com.stchool.ecommerce.util.InputUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CustomerController customerController = AppFactory.getCustomerControllerInstance();
        CustomerUI customerUI = new CustomerUI(customerController);

        char continueInput = 'Y';

        while (continueInput == 'Y' || continueInput == 'y') {
            System.out.println("E-Commerce Application");
            System.out.println("1. SignUp");
            System.out.println("2. Login");
            int choice = InputUtil.getIntInput("Enter you choice: ");

            switch (choice) {
                case 1:
                    try {
                        Customer registeredCustomer = customerUI.registerCustomer();
                        if (registeredCustomer != null) {
                            System.out.println("Customer registered successfully");
                        }
                    } catch (CustomerExistsException e) {
                        System.out.println("Registration failed");
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        Customer existingCustomer = customerUI.loginCustomer();
                        if (existingCustomer != null)
                            System.out.println("Login Successful, Welcome: " + existingCustomer.getName());
                    } catch (CustomerNotFoundException | InvalidCredentialsException e) {
                        System.out.println("Login Failed");
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid input");
            }
            continueInput = InputUtil.getCharInput("Do you want to continue (Y/N): ");
        }
    }
}