package com.example.loyaltym.controller;

import com.example.loyaltym.dto.MovimentoDto;
import com.example.loyaltym.model.Carta;
import com.example.loyaltym.model.Cliente;
import com.example.loyaltym.model.Movimento;
import com.example.loyaltym.model.Prodotto;
import com.example.loyaltym.repository.CartaRepository;
import com.example.loyaltym.repository.ClienteRepository;
import com.example.loyaltym.repository.MovimentoRepository;
import com.example.loyaltym.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovimentoController {

    @Autowired
    MovimentoRepository movimentoRepository;

    @Autowired
    CartaRepository cartaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdottoRepository prodottoRepository;

    Logger log = LoggerFactory.getLogger(MovimentoRepository.class);

    @PostMapping("/movimento")
    public @ResponseBody Movimento saveMovimento(@RequestBody MovimentoDto m) {
        // Processa il DTO e costruisce gli oggetti
        Movimento movimento = new Movimento();
        // Prima di tutto verifica il numero di carta
        Carta carta = cartaRepository.findCartaByNumero(m.getNumeroCarta())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "NumeroCartaNonValido"));
        movimento.setCarta(carta);
        // Codice del prodotto
        Prodotto prodotto = prodottoRepository.findProdottoByCodice(m.getCodiceProdotto())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Codice prodotto non valido"));
        // Recupero il Cliente
        movimento.setProdotto(prodotto);

        // Cliente
        Cliente cliente = carta.getCliente();
        movimento.setCliente(cliente);

        // A questo punto setto data e ora se manca
        if (m.getDataora()!=null)
            movimento.setDataora(m.getDataora());
        else
            movimento.setDataora(LocalDateTime.now());

        // Quantità Prezzo e Punti
        movimento.setQuantita(m.getQuantita());
        movimento.setImporto(m.getImporto());
        movimento.setPunti(m.getPunti());

        // Sconto
        movimento.setSconto(m.getSconto());
        movimento.setTotale(m.getTotale());

        // Tipo del movimento (1=T, 2=R, 3=P)
        if (m.getTipo() == 2) { // Reso
            movimento.setTotale(-movimento.getTotale());
            movimento.setPunti(-movimento.getPunti());
            movimento.setQuantita(-movimento.getQuantita());
        }
        if (m.getTipo() == 3) {
            movimento.setTotale(-movimento.getTotale());
            movimento.setPunti(-movimento.getPunti());
        }
        movimento.setMtipo(m.getTipo());
        Movimento saved = movimentoRepository.save(movimento);
        return saved;
    }


}
