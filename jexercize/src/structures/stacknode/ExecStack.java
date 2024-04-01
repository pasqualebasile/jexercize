package structures.stacknode;

public class ExecStack {


  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push("uno");
    System.out.println(stack.peek().getData());
    stack.push("due");
    System.out.println(stack.peek().getData());
    stack.push("tre");
    System.out.println(stack.peek().getData());


    System.out.println(stack.peek().getData());
    Node a = stack.pop();
    System.out.println(a.getData());
    Node b = stack.pop();
    System.out.println(b.getData());
    stack.pop();
    // System.out.println(stack.peek().getData());

    //
/*    Stack unoStackMoltoGigante = new Stack();

    for (int i=0; i<1000; i++) {
      unoStackMoltoGigante.push(String.valueOf(i));
    }
    System.out.println(unoStackMoltoGigante.peek().getData());*/

  }


}
