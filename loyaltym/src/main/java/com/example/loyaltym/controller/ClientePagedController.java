package com.example.loyaltym.controller;

import com.example.loyaltym.model.Cliente;
import com.example.loyaltym.repository.ClientePagedRepository;
import com.example.loyaltym.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientePagedController {

    @Autowired
    ClientePagedRepository clienteRepository;

    Logger log = LoggerFactory.getLogger(ClientePagedController.class);

    /**
     * API per ottenere tutti i `clienti`
     * @return una lista di {@link Cliente}
     */
    @GetMapping("/clientes_paged")
    public ResponseEntity<Page<Cliente>> getAllCliente(
            Pageable pageable
    ) {
        log.info("GET /clientes ");
        Page<Cliente> clientes  = clienteRepository.findAll(pageable);

        if (clientes.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(clientes, HttpStatus.OK);
    }


}
