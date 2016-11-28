package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bean.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastname);
}
