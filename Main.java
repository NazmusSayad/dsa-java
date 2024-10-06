
public class Main {
  public static void main(String[] args) {
    var list = new LinkedList();

    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    System.out.println(list.indexOf(10));
    System.out.println(list.contains(20));

    list.deleteFirst();

    list.print();
  }
}
