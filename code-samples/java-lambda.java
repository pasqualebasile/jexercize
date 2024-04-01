

// Sintassi 
(Parametri) -> { Corpo della lambda }

// Lambda senza parametri
() -> { System.out.println("lambda senza parametri."); }

// Lambda con un parametro
(numero) -> { return numero * 2; }

// Lambda con due parametri
(x, y) -> { return x + y; }



    static void printNumberList() {
        // List Iteration
        System.out.println("Stampa lista numeri -> ");
        List<Integer> numbers = List.of(5, 3, 11, 7);
        // Uso di Lambda
        numbers.forEach((n) -> {System.out.println(n);});
    }

    

    static void printNumberList() {
        System.out.println("Stampa lista numeri -> ");
        
        List<Integer> numbers = List.of(5, 3, 11, 7);
        // Method Reference
        numbers.forEach(System.out::println);
    }

    static void printNumberListWithConsumer() {
        System.out.println("Stampa con Consumer -> ");
        List<Integer> numbers = List.of(5, 3, 11, 7);
        // Uso di Consumer per memorizzare una lambda
        Consumer<Integer> stampa = (n) -> { System.out.println(n); };
        numbers.forEach(stampa);
    }   

    static void moltiplicaLista() {
        System.out.println("Moltiplica Lista -> ");
        List<Integer> numbers = List.of(5, 3, 11, 7);
        Consumer<Integer> moltiplica = (n -> n*=2) ;
        numbers.forEach(moltiplica);
        numbers.forEach(System.out::println);
    }
