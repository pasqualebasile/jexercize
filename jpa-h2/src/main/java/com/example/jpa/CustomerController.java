package com.example.jpa;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;
	
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        log.info("GET /api/customers");
        customers = customerRepository.findAll();

        if (customers.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }	
    
	
    
    @PostMapping("/customer")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
    	customer = customerRepository.save(customer);
    	return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> putCustomer(@PathVariable(value = "id") Long id,
    		@RequestBody Customer customer ) {
    	Optional<Customer> foundCustomer = customerRepository.findById(id);
    	if (!foundCustomer.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	customer = customerRepository.save(customer);
    	return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable(value = "id") Long id) {
    	Optional<Customer> foundCustomer = customerRepository.findById(id);
    	if (!foundCustomer.isPresent()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	customerRepository.deleteById(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
