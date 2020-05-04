package DFSVSBFS;

import java.util.List;

public class Node<T> {
  T val;
  List<Node<T>> adjacent;
  public Node(T val, List<Node<T>> adjacent){
    this.val = val;
    this.adjacent = adjacent;
  };

  public T getVal() {
    return val;
  }

  public List<Node<T>> getAdjacent() {
    return adjacent;
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", adjacent=" + adjacent +
        '}';
  }
}
