// recursively

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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inOrder = new ArrayList<>();

    if (root == null) {
      return inOrder;
    }
    recursive(root, inOrder);
    return inOrder;
  }
  private void recursive(TreeNode root, List<Integer> inOrder) {
    if (root == null) {
      return;
    }
    recursive(root.left,inOrder);
    inOrder.add(root.val);
    recursive(root.right,inOrder);
  }
}
