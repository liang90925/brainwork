/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return dfs(root.left, root.right);
  }
  private boolean dfs(TreeNode left, TreeNode right) {
    if (left == null) {
      return right == null;
    }
    if (right == null) {
      return left == null;
    }
    if (left.val != right.val) {
      return false;
    }
    if (!dfs(left.left, right.right)) {
      return false;
    }
    if (!dfs(left.right, right.left)) {
      return false;
    }
    return true;
  }
}
