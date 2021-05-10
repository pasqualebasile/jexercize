package xml.simplexml;

import java.io.StringWriter;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SimpleXmlOne {

  public static void main(String[] args) {
    Serializer serializer = new Persister();

    Record1 r1 = new Record1("Nome", "Codice", 21);

    StringWriter output = new StringWriter();

    try {
      serializer.write(r1, output);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(output);

  }

}
