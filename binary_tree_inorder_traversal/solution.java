// iteratively

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
    Stack<TreeNode> nodeStk = new Stack<>();

    if (root == null) {
      return inOrder;
    }

    TreeNode curr = root;

    while (curr != null || !stack.empty()) {
      while (curr != null) {
        nodeStk.add(curr);
        curr = curr.left;
      }
      curr = nodeStk.peek();
      inOrder.add(curr.val);
      nodeStk.pop();
      curr = curr.right;
    }
    return inOrder;
  }
}
