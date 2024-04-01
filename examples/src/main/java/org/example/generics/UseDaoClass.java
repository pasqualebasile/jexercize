package org.example.generics;

public class UseDaoClass {
    public static void main(String[] args) {
        DaoClass<String> oggetto1 = new DaoClass<>();
        System.out.println(oggetto1.getContatore(73)); // Stampa 1
        System.out.println(oggetto1.getContatore(72)); // Stampa 0


        DaoClass<Integer> oggetto2 = new DaoClass<>();
        System.out.println(oggetto2.getContatore(73)); // Stampa 1
        System.out.println(oggetto2.getContatore(72)); // Stampa 0
        System.out.println(oggetto2.getContatore(73)); // Stampa 1

        }
}
