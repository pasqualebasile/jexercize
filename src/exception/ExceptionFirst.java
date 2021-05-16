package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionFirst {

  public static final double divideByZero(int dividendo, int divisore) {
    try {
      return  (double) dividendo / divisore;
    }
    catch (ArithmeticException e) {
      throw new ArithmeticException();
    }
  }

  public static boolean openFile(String fileName) {
    File f = new File(fileName);
    return f.exists();
  }


   public static InputStream openStream(String fileName) {
     InputStream inputStream = null;
     try {
       inputStream = new FileInputStream(fileName);
     } catch (FileNotFoundException e) {
       // Log this Exception
       return null;
     }
     return inputStream;
  }


  public static void main(String[] args) {
    int x = 0;

    // System.out.println(10/x);

    // Caso 1 - Stampo l'errore
    try {
      System.out.println(10/x);
    } catch (ArithmeticException e ) {
      System.out.println("Exception Occurred: " + e.getMessage());
    }


    // Caso 2 - Ignoro l'errore (MAIIII)
    try {
      System.out.println(10/x);
    } catch (ArithmeticException e ) {

    }



    // Caso 3 - Prendo delle precauzioni
    try {
      System.out.println(10/x);
    } catch (ArithmeticException e ) {
      System.out.println(0);
    }


    // Caso 4 - Evito l'eccezione
    if (x != 0) {
      System.out.println(10 / x);
    } else {
      System.out.println(0);
    }

    System.out.println(divideByZero(10,0));

    // Caso del file
    if (openFile("prova.txt")) {
      System.out.println("File Trovato");
    } else {
      System.out.println("File Non Trovato!!");
    }

    InputStream fi = openStream("prova.txt");
    if (fi == null) {
      System.out.println("File (forse) Non Trovato");
    }
  }

}
