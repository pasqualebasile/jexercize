package org.example.lambda;


import java.util.List;
import java.util.function.Consumer;

public class ForEach {

    public static void main(String[] args) {
        ForEach forEach = new ForEach();
        forEach.printNumberList();
        forEach.printNumberListWithConsumer();
        forEach.moltiplicaLista();
    }


    void printNumberList() {
        System.out.println("Stampa lista numeri -> ");
        List<Integer> numbers = List.of(5, 3, 11, 7);
        // Uso di Lambda
        numbers.forEach((n) -> {System.out.println(n);});
        // Method Reference
        // numbers.forEach(System.out::println);
    }

    /**
     * Uso dell'interfaccia Consumer per memorizzare una lambda in una variabile
     */
    void printNumberListWithConsumer() {
        System.out.println("Stampa con Consumer -> ");
        List<Integer> numbers = List.of(5, 3, 11, 7);
        Consumer<Integer> stampa = (n) -> { System.out.println(n); };
        numbers.forEach(stampa);
    }

    /**
     * forEach non modifica una struttura
     */
    void moltiplicaLista() {
        System.out.println("Moltiplica Lista -> ");
        List<Integer> numbers = List.of(5, 3, 11, 7);
        Consumer<Integer> moltiplica = (n -> n*=2) ;
        numbers.forEach(moltiplica);
        numbers.forEach(System.out::println);
    }

}
