package xml.simplexml;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class OneList {

  @Attribute
  private int versione;

  @Element
  private String listName;

  @ElementList(inline = true)
  private List<One> list;

  public OneList() {
    this.list = new ArrayList<>();
    listName = "Lista";
    versione = 1;
  }

  public List<One> getList() {
    return list;
  }

  public void setList(List<One> list) {
    this.list = list;
  }

  public int getVersione() {
    return versione;
  }

  public void setVersione(int versione) {
    this.versione = versione;
  }

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  public void addList(One element) {
    list.add(element);
  }
}
