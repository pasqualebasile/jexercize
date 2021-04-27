package structures.stacknode;

/**
 * Classe che rappresenta il nodo di una struttura dati (Stack)
 */
public class Node {
  private String data;
  Node ptr;

  private Node() {
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
