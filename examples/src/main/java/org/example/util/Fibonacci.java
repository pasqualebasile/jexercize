package org.example.util;

import java.sql.Time;

/**
 * Gestione dei numeri di Fibonacci
 */
public class Fibonacci {
    LongCache longCache = new LongCache();
    public Long getRicorsiva(Long n) {
        Long cacheValue = longCache.get(n);
        if (cacheValue != null)
            return cacheValue;
        if (n==0)
            return 1L;
        if (n.equals(1L))
            return 1L;
        Long returnValue = getRicorsiva(n-1) + getRicorsiva(n-2);
        longCache.put(n, returnValue);
        return returnValue;
    }

    public Long getRicorsivaPura(Long n) {
        if (n==0)
            return 1L;
        if (n.equals(1L))
            return 1L;
        return getRicorsivaPura(n-1) + getRicorsivaPura(n-2);
    }

    public Long getIterativa(Long n) {
        if (n == 0 || n == 1) {
            return 1L;
        }

        Long prev = 1L;
        Long current = 1L;
        for (long l = 2; l <= n; l++) {
            Long next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        final long LIMIT = 64L;

        Timer tr = new Timer();
        Timer ti = new Timer();

        tr.start();
        for (long i = 0; i < LIMIT; i++ ) {
            Long fibonacci = f.getRicorsiva(i);
            System.out.println("Fibonacci " + i + " -> " + fibonacci);
        }
        tr.end();

        ti.start();
        for (long i = 0; i < LIMIT; i++ ) {
            Long fibonacci = f.getIterativa(i);
            System.out.println("Fibonacci " + i + " -> " + fibonacci);
        }
        ti.end();

        // Risultati
        System.out.println("Ricorsiva -> " + tr.getElapsedTime());
        System.out.println("Iterativa -> " + ti.getElapsedTime());

    }

}
