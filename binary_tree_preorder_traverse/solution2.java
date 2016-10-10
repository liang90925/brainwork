// recursive solution

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
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preOrder = new ArrayList<>();
    recursive(root, preOrder);
    return preOrder;
  }

  private void recursive(TreeNode root, List<Integer> preOrder) {
    if (root == null) {
      return;
    }
    preOrder.add(root.val);
    recursive(root.left, preOrder);
    recursive(root.right, preOrder);
  }
}
