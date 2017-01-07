/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // traverse
public class Solution {
  private TreeNode lastNode = null;
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    if (lastNode != null) {
      lastNode.right = root;
      lastNode.left = null;
    }
    lastNode = root;
    // 存下rightnode
    TreeNode right = root.right;
    flatten(root.left);
    flatten(right);
  }
}
