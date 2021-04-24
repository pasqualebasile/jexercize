package structures.stackarray;

public class Node {
  private String data;
  Node ptr;

  private Node() {
  }

  public Node(String data) {
    this.data = data;
    this.ptr = null;
  }

  public Node(String data, Node ptr) {
    this.data = data;
    this.ptr = ptr;
  }

  public String getData() {
    return data;
  }

  public Node getPtr() {
    return ptr;
  }
}
