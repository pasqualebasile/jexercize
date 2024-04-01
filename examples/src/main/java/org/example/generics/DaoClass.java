package org.example.generics;

import java.util.HashMap;
import java.util.Map;

public class DaoClass<T> {
    // Utilizza una mappa per tenere traccia del contatore per ogni tipo T
    private final Map<Integer, Integer> contatori = new HashMap<>();

    // Costruttore della classe che prende il tipo come argomento
    public DaoClass() {
        // Ottieni il contatore per il tipo corrente
//        int contatore = contatori.getOrDefault(companyId,0);
//
//        // Incrementa il contatore e aggiorna la mappa
//        contatore++;
//        contatori.put(companyId, contatore);
    }

    // Metodo statico per ottenere il contatore per un tipo specifico
    public <U> int getContatore(int companyId) {
        if (this.contatori.get(companyId) == null)
            this.contatori.put(companyId, 1);
        return contatori.get(companyId);
    }

    // Altri metodi della classe
}