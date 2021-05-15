package xml.simplexml;
import org.simpleframework.xml.*;

@Root
public class One {

  @Element
  private String nome;

  @Element
  private String codice;

  @Attribute
  private int versione;

  public One(String nome, String codice, int versione) {
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
