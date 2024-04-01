package com.example.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

	  List<Customer> findByLastName(String lastName);
	  
	  List<Customer> findByFirstName(String firstName);
	  
	  List<Customer> findAll();

	  Customer findById(long id);
	  
}
