package xml.simplexml;

import java.io.StringWriter;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class TwoSimpleXml {

  public static void main(String[] args) {
    Serializer serializer = new Persister();

    Two two = new Two("Nome", "Codice", 21);

    StringWriter output = new StringWriter();

    try {
      serializer.write(two, output);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println(output);

  }

}
