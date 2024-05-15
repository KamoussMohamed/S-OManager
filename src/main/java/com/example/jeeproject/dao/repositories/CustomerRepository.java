package com.example.jeeproject.dao.repositories;

import com.example.jeeproject.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findCustomerByCustomerId(Long customerId);
}
