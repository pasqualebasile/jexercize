package com.example.loyaltym.controller;

import com.example.loyaltym.model.Prodotto;
import com.example.loyaltym.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {

    @Autowired
    ProdottoRepository prodottoRepository;

    Logger log = LoggerFactory.getLogger(ProdottoRepository.class);

    @GetMapping("/{id}")
    public ResponseEntity<Prodotto> getProdotto(@PathVariable(value = "id") Long id) {
        log.info("GET /api/prodotti/{id} " + id);

        Optional<Prodotto> prodotto = prodottoRepository.findProdottoById(id);

        if (prodotto.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(prodotto.get(), HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<Page<Prodotto>> getAllProdotto(
            Pageable pageable
    ) {
        log.info("GET /api/prodotti ");
        Page<Prodotto> prodotti  = prodottoRepository.findAll(pageable);

        if (prodotti.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(prodotti, HttpStatus.OK);
    }

    @GetMapping("/byCode/{code}")
    public ResponseEntity<Prodotto> getProdottoByCode(@PathVariable(value = "code") String code) {
        log.info("GET /api/prodotti/byCode/{code} " + code);

        Optional<Prodotto> prodotto = prodottoRepository.findProdottoByCodice(code);

        if (prodotto.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(prodotto.get(), HttpStatus.OK);
    }


}
