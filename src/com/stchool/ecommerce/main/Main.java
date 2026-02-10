package com.stchool.ecommerce.main;

import com.stchool.ecommerce.controller.CustomerController;
import com.stchool.ecommerce.model.Customer;
import com.stchool.ecommerce.service.CustomerService;
import com.stchool.ecommerce.ui.CustomerMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Signup");
        System.out.println("Enter your choice :");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 :
                CustomerMenu customerMenu = new CustomerMenu();
                Customer customer = customerMenu.inputCustomerSignupData();

                CustomerController customerController = new CustomerController();
                Customer newCustomer = customerController.handleSignup(customer);

                System.out.println("Customer details :");
                CustomerService customerService = new CustomerService();
                customerService.displayCustomerDetails(newCustomer);
                break;
        }
        scanner.close();
    }
}