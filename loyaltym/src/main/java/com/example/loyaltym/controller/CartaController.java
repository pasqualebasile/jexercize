package com.example.loyaltym.controller;

import com.example.loyaltym.dto.AssociaCarta;
import com.example.loyaltym.dto.GenaratoreLotto;
import com.example.loyaltym.model.Carta;
import com.example.loyaltym.model.Cliente;
import com.example.loyaltym.repository.CartaRepository;
import com.example.loyaltym.repository.ClienteRepository;
import com.example.loyaltym.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CartaController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CartaRepository cartaRepository;

    Logger log = LoggerFactory.getLogger(CartaController.class);

    /**
     * API per ottenere tutti i `clienti`
     * @return una lista di {@link com.example.loyaltym.model.Carta}
     */
    @GetMapping("/carte")
    // @JsonView(Views.CartaConCliente.class)
    public ResponseEntity<List<Carta>> getAllCarte() {
        List<Carta> cartas = new ArrayList<>();
        log.info("GET /carte ");
        cartas  = cartaRepository.findAll();

        if (cartas.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cartas, HttpStatus.OK);
    }


    @GetMapping("/carte/{id}")
    // @JsonView(Views.CartaConCliente.class)
    public ResponseEntity<Carta> getCarta(@PathVariable(value = "id") Long id) {
        log.info("GET /carte/{id} " + id);

        Optional<Carta> carta = cartaRepository.findById(id);

        if (carta.isEmpty()) {
            // Nessun contenuto da ritornare
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(carta.get(), HttpStatus.OK);
    }

    @PutMapping("/carta/associa")
    // @JsonView(Views.CartaConCliente.class)
    public ResponseEntity<Carta> associaCarta(@RequestBody AssociaCarta associaCarta) {
        // Recupera il record se presente
        Carta _carta = cartaRepository.findCartaByNumero(associaCarta.getNumeroCarta())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Carta Non Trovata = " + associaCarta.getNumeroCarta()));

        // Controlla che il cliente esista
        Cliente _cliente = clienteRepository.findById(associaCarta.getClienteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente Non Trovato con Id " + associaCarta.getClienteId()));

        // Ora che sono noti entrambi
        _carta.setStatus(1);
        _carta.setCliente(_cliente);
        _carta.setData_emissione(LocalDate.now());

        Carta c = cartaRepository.save(_carta);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping("/carta/genera-lotto")
    public ResponseEntity generaLotto(@RequestBody GenaratoreLotto lotto) {
        Long from = Long.parseLong(lotto.getNumeroInizialeCarta());
        Long noCards = lotto.getNumeroCarte();
        LocalDate createDate = LocalDate.now();
        for (int c = 0; c<noCards; c++) {
            String cardNo = String.format("%012d", from + c);
            Carta card = new Carta();
            card.setData_creazione(createDate);
            card.setStatus(0);
            card.setPunti(0L);
            card.setNumero(cardNo);
            cartaRepository.save(card);
        }
        return ResponseEntity.ok().build();

    }
}
