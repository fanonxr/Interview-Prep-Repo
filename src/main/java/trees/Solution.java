package trees;

public class Solution {
  // method to validate a BST
  public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
  }

  // recursive helper method to handle validating a BST
  public boolean validate(TreeNode root, Integer max, Integer min) {
    // check for the base case of if the root is null
    if (root == null) return true;

    // check if the the left child is greater than the root
    if (max != null && root.val >= max) return false;
    if (min != null && root.val <= min) return false;

    // make the recursive call for both the left and right children
    return validate(root.left, root.val, min) && validate(root.right, root.val, max);
  }

  // method to find the maximum depth of a tree
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    // search the left and right children recursive
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    // return the max number on the recursive stack from that left and right child
    return Math.max(left, right) + 1; // add 1 for the parenet node
  }
}
