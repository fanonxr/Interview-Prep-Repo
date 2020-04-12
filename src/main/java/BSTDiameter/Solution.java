package BSTDiameter;

public class Solution {
  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode1.left.left = treeNode4;
    treeNode1.left.right = treeNode5;

    Solution solution = new Solution();

    System.out.println("Diameter = " + solution.diameterOfBinaryTree(treeNode1));
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
}
