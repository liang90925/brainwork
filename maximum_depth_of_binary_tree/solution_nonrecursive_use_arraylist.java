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
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    List<TreeNode> nodeList = new ArrayList<>();
    nodeList.add(root);

    int depth = 0;
    while (nodeList.size() > 0) {
      List<TreeNode> next = new ArrayList<>();
      for (TreeNode node : nodeList) {
        if (node.left != null) { next.add(node.left); }
        if (node.right != null) { next.add(node.right); }
      }
      nodeList = new ArrayList<>(next);
      depth++;
    }
    return depth;
  }
}
