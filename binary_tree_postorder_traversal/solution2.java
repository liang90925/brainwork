/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // iteratively and didn't the structure of the node;

public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new ArrayList<>();

    if (root == null) {
      return postOrder;
    }
    reverse(root, postOrder);
    return postOrder;
  }
  private void reverse(TreeNode root, List<Integer> postOrder) {
    if (root == null) {
      return;
    }
    reverse(root.left, postOrder);
    reverse(root.right, postOrder);
    postOrder.add(root.val);
  }
}
