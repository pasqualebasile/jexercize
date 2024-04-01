package com.example.loyaltym.controller;

import com.example.loyaltym.dto.GeneratoreScontrino;
import com.example.loyaltym.dto.MovimentoDto;
import com.example.loyaltym.model.Carta;
import com.example.loyaltym.model.Cliente;
import com.example.loyaltym.repository.CartaRepository;
import com.example.loyaltym.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/cassa")
public class CassaController {

    @Autowired
    CartaRepository cartaRepository;

    @PostMapping("/generaSingolo")
    public @ResponseBody GeneratoreScontrino generaScontrino (
            @RequestBody GeneratoreScontrino generatoreScontrino
    ) {
        // Prima recuperiamo il cliente tramite il numero di carta
        Carta carta = cartaRepository.findCartaByNumero(generatoreScontrino.getCarta())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "NumeroCartaNonValido"));

        // Calcolo il numero di righe
        Integer righe = generatoreScontrino.getTransazioni();



        MovimentoDto movToSend = new MovimentoDto();


        return null;
    }
}
