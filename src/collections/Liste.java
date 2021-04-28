package collections;

import java.util.ArrayList;
import java.util.List;

public class Liste {
  static List<String> lista = new ArrayList<>();

  public static void main(String[] args) {
    lista.add("uno");
    lista.add("due");
    lista.add("tre");

    for (String x : lista) {
      System.out.println(x);
    }


  }


}
