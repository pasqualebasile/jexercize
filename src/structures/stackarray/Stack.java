package structures.stackarray;

public class Stack {
  private int maxSize;
  private Node[] iStack;
  private int head;

  public Stack(int size) {
    maxSize = size;
    iStack = new Node[maxSize];
    head = -1;
  }

  public void push (String s) {
    iStack[++head] = new Node(s);
  }

  public Node pop() {
    return iStack[head--];
  }

  public Node peek() {
    return iStack[head];
  }

  public boolean isEmpty() {
    return head == -1;
  }

  public boolean isFull() {
    return head == maxSize - 1 ;
  }


}
