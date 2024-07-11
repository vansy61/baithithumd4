package com.example.baithim4.service;

import com.example.baithim4.model.Customer;

public interface ICustomerService {
    Iterable<Customer> findAll();
}
