/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // iteratively, but this changed the structure of the node;
 
public class Solution {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new ArrayList<>();
    Stack<TreeNode> nodeStk = new Stack<>();

    if (root == null) {
      return postOrder;
    }

    nodeStk.push(root);

    while (!nodeStk.empty()) {
      TreeNode top = nodeStk.peek();

      if (top.left == null && top.right == null) {
        postOrder.add(top.val);
        nodeStk.pop();
      }
      if (top.left != null) {
        nodeStk.push(top.left);
        top.left = null;
        continue;
      }
      if (top.right != null) {
        nodeStk.push(top.right);
        top.right = null;
        continue;
      }
    }
    return postOrder;
  }
}
