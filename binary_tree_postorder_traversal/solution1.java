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
    Stack<TreeNode> nodeStk = new Stack<>();

    if (root == null) {
      return postOrder;
    }

    TreeNode prev = null; // previously traversed node
    TreeNode curr = root;
    nodeStk.push(root);

    while (!nodeStk.empty()) {
      curr = nodeStk.peek();
      if (prev == null || prev.left == curr || prev.right == curr) {
        if (curr.left != null) {
          nodeStk.push(curr.left);
        } else if (curr.right != null) {
          nodeStk.push(curr.right);
        }
      } else if (curr.left == prev) {
        if (curr.right != null) {
          nodeStk.push(curr.right);
        }
      } else {
        // traverse up the tree from the right
        postOrder.add(curr.val);
        nodeStk.pop();
      }
      prev = curr;
    }
    return postOrder;
  }
}
