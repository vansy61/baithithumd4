package com.example.baithim4.repository;

import com.example.baithim4.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepo extends CrudRepository<Customer, Long> {
}
