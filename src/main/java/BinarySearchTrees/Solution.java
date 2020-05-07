package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(1);
    TreeNode sub1 = new TreeNode(2);
    TreeNode sub2 = new TreeNode(3);
    TreeNode sub3 = new TreeNode(4);
    TreeNode sub4 = new TreeNode(5);
    root.left = sub1;
    root.right = sub2;
    sub1.left = sub3;
    sub2.right = sub4;
    System.out.println(solution.isCousins(root, 5, 4));
  }

  public boolean isCousins(TreeNode root, int x, int y) {
    // Use BFS to search for the nodes
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    // to help us identify what generation we are in the tree
    int gen = 1;

    while (!queue.isEmpty()) {
      if (gen == 0) gen = queue.size();
      TreeNode node = queue.remove();
      gen--;
      int target = -1;

      // check the left tree
      if (node.left != null) {
        if (node.left.val == x) {
          target = y;
        } else if (node.left.val == y) {
          target = x;
        } else {
          queue.add(node.left);
        }
      }

      // check the right tree
      if (node.right != null) {
        if (node.right.val == x) {
          target = y;
        } else if (node.right.val == y) {
          target = x;
        } else {
          queue.add(node.right);
        }
      }

      //
      if (target != -1) {
        while (gen > 0) {
          node = queue.remove();
          gen--;

          if (node.left != null && node.left.val == target) return true;
          if (node.right != null && node.right.val == target) return true;
        }
        return false;
      }
    }
    return false;
  }
}
