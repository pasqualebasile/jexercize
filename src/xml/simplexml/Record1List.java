package xml.simplexml;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Record1List {

  @ElementList
  private List<Record1> list;

  public Record1List() {
    this.list = new ArrayList<>();
  }

  public List<Record1> getList() {
    return list;
  }

  public void setList(List<Record1> list) {
    this.list = list;
  }

  public void addList(Record1 element) {
    list.add(element);
  }
}
