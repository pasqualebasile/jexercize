package org.example.generics;

public class UseMiaClasse {
    public static void main(String[] args) {
        MiaClasse<String> oggetto1 = new MiaClasse<>(String.class);
        System.out.println(MiaClasse.getContatore(String.class)); // Stampa 1

        MiaClasse<Integer> oggetto2 = new MiaClasse<>(Integer.class);
        System.out.println(MiaClasse.getContatore(Integer.class)); // Stampa 1

        System.out.println(MiaClasse.getContatore(String.class)); // Stampa 1 ancora per il tipo String
    }
}
