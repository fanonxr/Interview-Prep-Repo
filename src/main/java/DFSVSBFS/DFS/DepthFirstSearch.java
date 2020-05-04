package DFSVSBFS.DFS;

import DFSVSBFS.Node;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch<T> {
  /** Depth first search implementation
   * We use a stack to keep track of the nodes
   * and a HashSet to know if we have visited or not
   * */
  public void dfs(Node<T> start) {
    // create our stack and set to keep track of the nodes we have traversed
    Stack<Node<T>> stack = new Stack<>();
    HashSet<Node<T>> seen = new HashSet<>();
    // start searching by adding start to top of the stack
    stack.push(start);
    // traverse the graph while the stack is not empty
    while (!stack.isEmpty()) {
      // pop off the element at the top of the stack
      Node<T> curr = stack.pop();
      // check if the curr node has been see
      if (!seen.contains(curr)) seen.add(curr);
      System.out.println(curr.toString());

      // process the node other
      for (Node<T> adjacent: curr.getAdjacent()) {
        // check if the children have been seen add to the stack
        if (!seen.contains(adjacent)) stack.push(adjacent);
      }
    }
  }
}
