package xml.simplexml;

import java.io.StringWriter;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class OneSimpleXml {

  public static void main(String[] args) {
    Serializer serializer = new Persister();

    One one = new One("Nome", "Codice", 21);

    StringWriter output = new StringWriter();

    try {
      serializer.write(one, output);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(output);

  }

}
