package oo.geometric.basic;

public class Ellisse {
  private double smajor = 0.0;
  private double sminor = 0.0;

  // Costrutture di default
  public Ellisse() {
  }


  // Costrutture con Argomenti
  public Ellisse(double semiAsseMaggiore, double semiAsseMinore) {
    smajor = semiAsseMaggiore;
    sminor = semiAsseMinore;
  }

  // Metodi
  public double area() {
    return Math.PI * smajor * sminor;
  }

  public double perimetro() {
    // Nota: approssimato
    return 2.8 * Math.PI  * Math.sqrt((smajor*smajor + sminor*sminor)/2);
  }
}
