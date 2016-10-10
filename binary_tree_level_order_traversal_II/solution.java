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
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> nodeQue = new LinkedList<>();
    nodeQue.offer(root);

    while (!nodeQue.isEmpty()) {
      int size = nodeQue.size();
      List<Integer> levelRst = new ArrayList<>();
      while (size-- > 0) {
        TreeNode curr = nodeQue.poll();
        levelRst.add(curr.val);
        if (curr.left != null) {
          nodeQue.offer(curr.left);
        }
        if (curr.right != null) {
          nodeQue.offer(curr.right);
        }
      }
      result.add(levelRst);
    }
    Collections.reverse(result);
    return result;
  }
}
