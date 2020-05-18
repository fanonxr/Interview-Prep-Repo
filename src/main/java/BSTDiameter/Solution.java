package BSTDiameter;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode treeNode1 = new TreeNode(100);
    TreeNode treeNode2 = new TreeNode(75);
    TreeNode treeNode3 = new TreeNode(110);
    TreeNode treeNode4 = new TreeNode(65);
    TreeNode treeNode5 = new TreeNode(110);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode1.left.left = treeNode4;
    treeNode1.left.right = treeNode5;
    // System.out.println(isValidBST(treeNode1));
    System.out.println(solution.getNodesWithSumEqualTarget(treeNode1, 403).toString());
  }

  public int diameterOfBinaryTree(TreeNode root) {
    int[] res = new int[1];
    helper(root, res);
    return res[0];
  }

  private int helper(TreeNode root, int[] res) {
    // base case
    if (root == null) return -1;

    int left = helper(root.left, res);
    int right = helper(root.right, res);

    res[0] = Math.max(res[0], left + right + 2);
    return Math.max(left + 1, right + 1);
  }

  //         100
  //        /    \
  //       75    110
  //     /   \
  //   65     77
  // root.value  is max compared to left subtree
  // root.value is static global
  // root is min compared to right subtree
  // target: the goal is to find  a sum of the nodes equal to the target

  public List<Integer> getNodesWithSumEqualTarget(TreeNode root, Integer target) {
    List<Integer> pathValues = new ArrayList<>();
    return helperNodesSumEqual(root, target, pathValues);
  }
  public List<Integer> helperNodesSumEqual(TreeNode root, Integer target, List<Integer> path) {
    if (root != null) {
      if (root.val > target) return path;
      else {
        // check to see if we reached our target
        if (target == 0) return path;
        // add the root to the path
        path.add(root.val);
        // update the target
        target -= root.val;

        // check recursively on the left and the right // DFS
        helperNodesSumEqual(root.left, target, path);
        helperNodesSumEqual(root.right, target, path);
      }
    }
    return path;
  }

  public static boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  public static boolean isValidBSTHelper(TreeNode root, Integer max, Integer min) {
    // base case, our root val is
    if (root == null) return false;
    // check if the root val is smaller on left sub tree and bigger on the right sub tree
    if (max != null && root.val >= max) return false;
    if (min != null && root.val <= min) return false;
    // recursively check the sub trees as well while passing in the root as the max for left and min for the right
    return (isValidBSTHelper(root.left, root.val, min) && isValidBSTHelper(root.right, max, root.val));
  }

  // calculating the max depth of the binary tree
  public static int maxDepth(TreeNode root) {
    if (root == null) return 0;

    // find the depth for the right and for the left
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    // compare to see which is the max
    if (leftDepth < rightDepth) return rightDepth + 1;
    else return leftDepth + 1;
  }

  public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return checkSymmetric(root.left, root.right);
  }

  public static boolean checkSymmetric(TreeNode leftNode, TreeNode rightNode) {
    if (leftNode == null && rightNode == null) {
      return true;
    }

    // check for the false case
    if (leftNode != null && rightNode != null) {
      return (leftNode.val == rightNode.val) &&
          (checkSymmetric(leftNode.right, rightNode.left) &&
              checkSymmetric(leftNode.left, rightNode.right));
    }
    return false;
  }
}
