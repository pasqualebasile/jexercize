package org.example.util;

import java.util.Random;

/**
 * Timer è una classe di utilità per misurare il tempo trascorso tra la chiamate dei due metodi
 * start() ed end().<br/>
 * L'accuratezza è al millisecondo.
 */
public class Timer {
    private Long startTime;
    private Long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void end() {
        endTime = System.currentTimeMillis();
    }

    /**
     * Ritorna il tempo trascorso tra lo start() e l'end()  che è
     * la differenza tra endTime e startTime in millisecondi.
      * @return il numero di millisecondi trascorsi tra start() ed end()
     */
    public Long getElapsedTime() {
        return (endTime - startTime);
    }

    public static void main(String[] args) {
        String s = "start";
        final int limit = 1000000;
        Timer tt = new Timer();
        tt.start();
        int m = 42;
        for (Integer i = 0; i< limit; i++ ) {
            Random rnd = new Random(m % 10000);
            int x = rnd.nextInt(10000);
            String t  = String.valueOf(x);
            m = Integer.valueOf(t);
        }
        tt.end();
        System.out.println("Tempo -> " + tt.getElapsedTime() + " ms");
    }

}
