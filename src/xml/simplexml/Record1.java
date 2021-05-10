package xml.simplexml;
import org.simpleframework.xml.*;

@Root
public class Record1 {

  @Element
  private String nome;

  @Element
  private String codice;

  @Attribute
  private int versione;

  public Record1(String nome, String codice, int versione) {
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
