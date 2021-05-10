package xml.simplexml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SimpleXmlList {

  public static void main(String[] args) {
    Serializer serializer = new Persister();
    List<Record1> record1List = new ArrayList<>();
    record1List.add(new Record1("Primo", "I", 21));

    StringWriter output = new StringWriter();

    Record1List list = new Record1List();
    list.setList(record1List);
    // list.addList(new Record1("Primo", "I", 21));
    // list.addList(new Record1("Secondo", "II", 21));

    try {
      serializer.write(list, output);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(output);
  }

}
