package com.example.accessingdatapostgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByName(String name);
    
    List<User> findUserByNameIgnoreCase(String name);
    
    List<User> findUserByNameContainingIgnoreCase(String name);

    Optional<User> findById(Integer integer);
}