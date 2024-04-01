package org.example.generics;

import java.util.HashMap;
import java.util.Map;

public class MiaClasse<T> {
    // Utilizza una mappa per tenere traccia del contatore per ogni tipo T
    private static final Map<Class<?>, Integer> contatori = new HashMap<>();

    // Costruttore della classe che prende il tipo come argomento
    public MiaClasse(Class<T> tipo) {
        // Ottieni il contatore per il tipo corrente
        int contatore = contatori.getOrDefault(tipo, 0);

        // Incrementa il contatore e aggiorna la mappa
        contatore++;
        contatori.put(tipo, contatore);
    }

    // Metodo statico per ottenere il contatore per un tipo specifico
    public static <U> int getContatore(Class<U> tipo) {
        return contatori.getOrDefault(tipo, 0);
    }

    // Altri metodi della classe
}
