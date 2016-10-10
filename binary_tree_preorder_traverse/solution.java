// Iterative version
// using the stack to store the root
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
    Stack<TreeNode> nodeStk = new Stack<>();

    if (root == null) {
      return preOrder;
    }
    nodeStk.push(root);

    while (!nodeStk.empty()) {
      TreeNode node = nodeStk.pop();
      preOrder.add(node.val);
      if (node.right != null) {
        nodeStk.push(node.right);
      }
      if (node.left != null){
        nodeStk.push(node.left);
      }
    }
    return preOrder;
  }
}
