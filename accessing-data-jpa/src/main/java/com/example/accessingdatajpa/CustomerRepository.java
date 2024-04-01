package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);
    
    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    
    List<Customer> findByFirstNameIgnoreCase(String firstName);

    
    Customer findById(long id);
}