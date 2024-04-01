package com.example.loyaltym.repository;

import com.example.loyaltym.model.Carta;
import com.example.loyaltym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CartaRepository extends JpaRepository<Carta, Long>  {

    Optional<Carta> findCartaByNumero(String numero);

    Optional<Carta> findCartaByCliente(Cliente cliente);

    Optional<Carta> findCartaByNumeroAndStatus(String numero, Integer status);
}
