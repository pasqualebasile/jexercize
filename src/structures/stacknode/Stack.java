package structures.stacknode;

/**
 * Classe che implementa la struttura Stack
 */
public class Stack {
  private Node head = null;

  public Stack() {
  }

  /**
   * Push a Node on the top of the Stack
   * @param s
   */
  public void push (String s) {
    this.head = new Node(s, this.head);
  }

  public void pop() {
    if (this.head != null) {
      this.head = this.head.getPtr();
    }
    // Come gestiamo il caso in cui this.head == null ?
    // Come possiamo ritornare l'oggetto puntato ?
  }

  public Node peek() {
    return this.head;
  }

}
