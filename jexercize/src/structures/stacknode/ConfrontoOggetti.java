package structures.stacknode;

public class ConfrontoOggetti {


  public static void main(String[] args) {

    // I Caso Due stringhe
    String s1 = "Stringa";
    String s2 = "Stringa";
    System.out.println("Caso 1 :" + Boolean.toString(s1 == "Stringa"));
    System.out.println("Caso 1 :" + s1.equals(s2));

    // Altro Caso
    String o1 = new String("JuveLadra");
    String o2 = new String("JuveLadra");
    System.out.println("Caso 2 :" + Boolean.toString(o1 == o2));
    System.out.println("Caso 2 " + o1.equals(o2));

    // Caso dei Long
    Long l1 = 0L;
    Long l2 = 0L;
    System.out.println("Caso 3 :" + Boolean.toString(l1 == l2));
    System.out.println("Caso 3 :" + l1.equals(l2));

    l1 = 0L;
    l2 = new Long(0);
    System.out.println("Caso 4 :" + Boolean.toString(l1 == l2));
    System.out.println("Caso 4 :" + l1.equals(l2));

    l1 = 221L;
    l2 = 221L;
    System.out.println("Caso 5 :" + Boolean.toString(l1 == l2));
    System.out.println("Caso 5 :" + l1.equals(l2));

    // Caso dei Long
    // https://www.baeldung.com/java-compare-long-values
    l1 = 221L;
    l2 = 221L;
    System.out.println("Caso 6 :" + Boolean.toString(l1.longValue() == l2.longValue()));
    System.out.println("Caso 6 :" + l1.equals(l2));

  }

}
