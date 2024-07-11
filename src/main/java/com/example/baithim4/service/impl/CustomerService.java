package com.example.baithim4.service.impl;

import com.example.baithim4.model.Customer;
import com.example.baithim4.repository.ICustomerRepo;
import com.example.baithim4.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;
    @Override
    public Iterable<Customer> findAll() {
        return customerRepo.findAll();
    }
}
