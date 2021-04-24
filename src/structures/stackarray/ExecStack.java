package structures.stackarray;

public class ExecStack {
  public static final int SIZE = 32;

  public static void main(String[] args) {

    Stack stack = new Stack(SIZE);
    stack.push("uno");
    stack.push("due");
    stack.push("tre");

    System.out.println(stack.peek().getData());
    System.out.println(stack.peek().getData());
    stack.pop();
    System.out.println(stack.peek().getData());
    stack.pop();
    System.out.println(stack.peek().getData());
    stack.pop();
    System.out.println(stack.peek().getData());

  }


}
