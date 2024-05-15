package com.example.jeeproject.services;

import com.example.jeeproject.dao.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component


public interface CustomerManager {
    public Customer createCustomer(Customer customer);
    public Customer addCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer getCustomerById(Long customerId);
    public List<Customer> getAllCustomers();
    public boolean deleteCustomerByCustomerId(Long customerId);

}
