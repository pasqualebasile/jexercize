package xml.simplexml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ObjectTwo")
public class Two {

  @Element(name = "name")
  private String nome;

  @Element(name = "code")
  private String codice;

  @Attribute (name= "version")
  private int versione;

  public Two(String nome, String codice, int versione) {
    this.nome = nome;
    this.codice = codice;
    this.versione = versione;
  }

  public String getMessage() {
    return nome + " " + codice;
  }

  public int getVersion() {
    return versione;
  }

}
