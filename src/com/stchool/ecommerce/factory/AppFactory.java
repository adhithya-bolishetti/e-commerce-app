package com.stchool.ecommerce.factory;

import com.stchool.ecommerce.controller.CustomerController;
import com.stchool.ecommerce.repository.CustomerRepository;
import com.stchool.ecommerce.service.CustomerService;
import com.stchool.ecommerce.service.CustomerServiceImpl;
import com.stchool.ecommerce.util.CsvReader;

public class AppFactory {
    public static CsvReader csvReader = null;
    public static CustomerRepository customerRepository = null;
    public static CustomerService customerService = null;
    public static CustomerController customerController = null;

    public static CsvReader getCsvReaderInstance() {
        if(csvReader == null) {
            csvReader = new CsvReader();
        }
        return csvReader;
    }

    public static CustomerRepository getCustomerRepositoryInstance() {
        if(customerRepository == null) {
            customerRepository = new CustomerRepository(getCsvReaderInstance());
        }
        return customerRepository;
    }

    public static CustomerService getCustomerServiceInstance() {
        if(customerService == null) {
            customerService = new CustomerServiceImpl(getCustomerRepositoryInstance());
        }
        return customerService;
    }

    public static CustomerController getCustomerControllerInstance() {
        if(customerController == null) {
            customerController = new CustomerController(getCustomerServiceInstance());
        }
        return customerController;
    }
}
