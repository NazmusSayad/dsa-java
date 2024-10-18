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
  private int size = 0;

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

  public int[] toArray() {
    int[] array = new int[size];
    var current = first;
    var i = 0;
    while (current != null) {
      array[i++] = current.value;
      current = current.next;
    }
    
    return array;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
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

    size++;
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

    size++;
  }

  public void deleteFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
    } else {
      var second = first.next;
      first.next = null;
      first = second;
    }

    size--;
  }

  public void deleteLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
    } else {
      last = getPrevious(last);
      last.next = null;
    }

    size--;
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
}
