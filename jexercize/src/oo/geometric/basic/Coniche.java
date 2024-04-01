package oo.geometric.basic;

public class Coniche {

  public static void StampaArea(Ellisse o) {
    System.out.println("Area --> : " + o.area());
  }

  public static void main(String[] args) {
    Ellisse ellisse = new Ellisse(2,4);
    System.out.println("Area: " + ellisse.area());
    System.out.println("Perimetro: " + ellisse.perimetro());

    Cerchio cerchio = new Cerchio(5);
    System.out.println("Area: " + cerchio.area());
    System.out.println("Perimetro: " + cerchio.perimetro());

    StampaArea(ellisse);
    StampaArea(cerchio);

    System.out.println("Classe: " + cerchio.getClass().getName());
    System.out.println("Classe: " + ellisse.getClass().getName());
  }

}
