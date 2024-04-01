package xml.simplexml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SimpleXmlList {

  public static void main(String[] args) {
    Serializer serializer = new Persister();
    List<One> oneList = new ArrayList<>();
    oneList.add(new One("Primo", "I", 21));
    oneList.add(new One("Secondo", "II", 21));

    StringWriter output = new StringWriter();

    OneList list = new OneList();
    list.setList(oneList);
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
