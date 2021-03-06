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

  /** Find the largest smallest key from the integer that is passed in
   * */
  public int findLargestSmallestKey(TreeNode root, int num) {
    if (root == null) return -1;
    // keep track of the roots key value every time you progress down the tree
    int keyValue = -1;

    // traverse through the tree
    while (root != null) {
      // check to traverse the left or the right
      if (root.val > num) {
        keyValue = root.val;
        root = root.left;
      } else {
        keyValue = root.val;
        root = root.right;
      }
    }

    return keyValue;
  }

  /** Checking if a binary tree is symmertic
   * */
  public boolean isSymmetric(TreeNode root) {
    // base case for the root
    if (root == null) return true;
    // check symmetry recursively
    return checkSymmetry(root.left, root.right);
  }

  public boolean checkSymmetry(TreeNode leftNode, TreeNode rightNode) {
    // check if the left and right node are null
    if (leftNode == null && rightNode == null) return true;

    // check recursively if their children are not null
    if (leftNode != null && rightNode != null) {
      return leftNode.val == rightNode.val &&
          (checkSymmetry(leftNode.left, rightNode.right) && checkSymmetry(leftNode.right, rightNode.left));
    }
    return false;
  }

  public boolean hasPath(TreeNode root, int target) {
    // check if root is a tree
    if (root == null) {
      return false;
    }

    // check if we are at a leaf node
    boolean isLeafNode = root.left == null && root.right == null;

    // check if our path is equal to 0
    if (isLeafNode && target - root.val == 0) {
      return true;
    }

    // check our recursive case for left and right trees
    return hasPath(root.left, target - root.val) || hasPath(root.right, target - root.val);

  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return buildBST(nums ,0, nums.length);
  }

  private TreeNode buildBST(int[] arr,int start, int end) {
    // check to see if start is greater than the end
    if (start >= end) {
      // the list is empty
      return null;
    }
    // find the mid point of the array since I know that will be my root
    int mid = start + ((end - start) / 2);
    // create my node from the midpoint
    TreeNode root = new TreeNode(arr[mid]);
    // build up from the root on the left and right
    root.left = buildBST(arr, start, mid);
    root.right = buildBST(arr, mid + 1, end);

    return root;
  }
}
