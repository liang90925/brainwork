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
  public boolean isBalanced(TreeNode root) {
    return diffDepth(root) != -1;
  }

  private int diffDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = diffDepth(root.left);
    int right = diffDepth(root.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }
}
