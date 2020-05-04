package DFSVSBFS.BFS;

import DFSVSBFS.Node;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> {
  /** Method to execture BFS */
  public void bfs(Node<T> start) {
    // create a data structures
    Queue<Node<T>> queue = new LinkedList<>();
    HashSet<Node<T>> seen = new HashSet<>();
    // add the start onto the queue
    queue.add(start);
    // traverse the graph
    while (!queue.isEmpty()) {
      // poll it off the list
      Node<T> curr = queue.poll();
      if (!seen.contains(curr)) seen.add(curr);
      // handle processing the current node here
      System.out.println(curr.toString());

      // add all of the children to the queue
      for (Node<T> adjacent: curr.getAdjacent()) {
        if (!seen.contains(adjacent)) queue.add(adjacent);
      }

    }
  }
}
