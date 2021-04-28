package structures.stacknode;

/**
 * Classe che implementa la struttura Stack
 */
public class StackInitial {
  private Node head = null;

  public StackInitial() {
  }

  /**
   * Push a Node on the top of the Stack
   * @param s
   */
  public void push (String s) {
    this.head = new Node(s, this.head);
  }

  public Node pop() {
    if (this.head != null) {
      Node copia = new Node(this.head.getData(), null);
      this.head = this.head.getPtr();
      return copia;
    }
    else {
      return null;
    }
    // Come gestiamo il caso in cui this.head == null ?
    // Come possiamo ritornare l'oggetto puntato ? E in quale punto lo ritorno?
  }

  public Node peek() {
    return this.head;
  }

}
