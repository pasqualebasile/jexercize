package com.example.loyaltym.controller;

import com.example.loyaltym.model.Cliente;
import com.example.loyaltym.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    Logger log = LoggerFactory.getLogger(ClienteController.class);

    /**
     * API per ottenere tutti i `clienti`
     * @return una lista di {@link Cliente}
     */
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllCliente() {
        List<Cliente> clientes = new ArrayList<>();
        log.info("GET /clientes ");
        clientes  = clienteRepository.findAll();

        if (clientes.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }


    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable(name = "id") Long id) {
        log.info("GET /clientes/{id} " + id);
        Optional<Cliente> cliente  = clienteRepository.findClienteById(id);

        if (cliente.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
    }
}
