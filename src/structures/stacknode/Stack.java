package structures.stacknode;

public class Stack {
  private Node head = null;

  public Stack() {
  }

  public void push (String s) {
    this.head = new Node(s, this.head);
  }

  public void pop() {
    if (this.head != null) {
      this.head = this.head.getPtr();
    }
    // Come gestiamo il caso in cui this.head == null;
  }

  public Node peek() {
    return this.head;
  }

}
