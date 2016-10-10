// divide and conquer

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
    if (root == null) {
      return preOrder;
    }

    // divide
    List<Integer> left = preorderTraversal(root.left);
    List<Integer> right = preorderTraversal(root.right);

    // conquer
    preOrder.add(root.val);
    preOrder.addAll(left);
    preOrder.addAll(right);

    return preOrder;
  }
}
