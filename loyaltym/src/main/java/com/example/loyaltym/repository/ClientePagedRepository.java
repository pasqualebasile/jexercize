package com.example.loyaltym.repository;

import com.example.loyaltym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientePagedRepository extends PagingAndSortingRepository<Cliente, Long> {

}
