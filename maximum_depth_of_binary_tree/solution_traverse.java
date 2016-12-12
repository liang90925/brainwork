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
  private int depth;
  public int maxDepth(TreeNode root) {
    depth = 0;
    helper(root, 1);
    return depth;
  }
  private void helper(TreeNode root, int currDepth) {
    if (root == null) {
      return;
    }
    if (currDepth > depth) {
      depth = currDepth;
    }
    helper(root.left, currDepth + 1);
    helper(root.right, currDepth + 1);
  }
}
