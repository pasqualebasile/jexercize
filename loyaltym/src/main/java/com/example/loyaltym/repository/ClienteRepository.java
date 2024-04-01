package com.example.loyaltym.repository;

import com.example.loyaltym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
    Optional<Cliente> findClienteById(Long id);


}
