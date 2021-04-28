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

  /**
   * Ritorna il nodo sul top dello stack e lo elimina
   * @return  un {@link Node}
   * TODO: Dovrò modificare qualcosa nei moduli che utilizzano tale classe?
   */
  public Node pop() {
    if (this.head != null) {

      // Creo una copia di un oggetto (manuale)
      Node node = new Node(this.head);

      // Setto i puntatori
      this.head = this.head.getPtr();
      return node;
    }
    // Nel caso non ci sia nulla sul top dello stack, ritorna NULL
    return null;
    // Come gestiamo il caso in cui this.head == null ?
    // Come possiamo ritornare l'oggetto puntato ?
  }

  public Node peek() {
    return this.head;
  }

}
