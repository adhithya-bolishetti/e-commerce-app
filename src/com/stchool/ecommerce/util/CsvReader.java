package com.stchool.ecommerce.util;

import com.stchool.ecommerce.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public List<Customer> getCustomersFromCsv() {
        List<Customer> customers = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/java-fsd-workspace/Java-Workspace/e-commerce-app"));
            bufferedReader.readLine();

            String customerData = bufferedReader.readLine();
            while (customerData != null) {
                String[] data = customerData.split(",");

                Customer customer = new Customer();
                customer.setId(Integer.parseInt(data[0]));
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);
                customer.setContactNo(data[4]);
                customers.add(customer);

                customerData = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }
}
