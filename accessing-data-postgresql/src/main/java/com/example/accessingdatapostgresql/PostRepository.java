package com.example.accessingdatapostgresql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<User, Integer>  {

}
