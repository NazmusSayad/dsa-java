import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList {
  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
      this.next = null;
    }
  }

  private Node first;
  private Node last;

  private Node getPrevious(Node node) {
    var current = first;
    while (current != null) {
      if (current.next == node) {
        return current;
      }

      current = current.next;
    }

    return null;
  }

  public String toString() {
    var array = new ArrayList<>();
    var current = first;
    while (current != null) {
      array.add(current.value);
      current = current.next;
    }

    return array.toString();
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void addLast(int value) {
    var node = new Node(value);

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      last.next = node;
      last = node;
    }
  }

  public void addFirst(int value) {
    var node = new Node(value);

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      node.next = first;
      first = node;
    }
  }

  public int indexOf(int value) {
    int index = 0;

    var current = first;
    while (current != null) {
      if (current.value == value) {
        return index;
      }

      current = current.next;
      index++;
    }

    return -1;
  }

  public boolean contains(int value) {
    int index = indexOf(value);
    return index != -1;
  }

  public void deleteFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
      return;
    }

    var second = first.next;
    first.next = null;
    first = second;
  }

  public void deleteLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
      return;
    }

    last = getPrevious(last);
    last.next = null;
  }
}
