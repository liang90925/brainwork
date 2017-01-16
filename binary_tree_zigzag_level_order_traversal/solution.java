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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Stack<TreeNode> currLevel = new Stack<>();
    Stack<TreeNode> nextLevel = new Stack<>();
    currLevel.add(root);
    List<List<Integer>> result = new ArrayList<>();
    boolean currOrder = true;

    while (!currLevel.isEmpty()) {
      List<Integer> oneLevel = new ArrayList<>();
      while (!currLevel.isEmpty()) {
        TreeNode curr = currLevel.pop();
        oneLevel.add(curr.val);
        if (currOrder) {
          if (curr.left != null) {
            nextLevel.push(curr.left);
          }
          if (curr.right != null) {
            nextLevel.push(curr.right);
          }
        } else {
          if (curr.right != null) {
            nextLevel.push(curr.right);
          }
          if (curr.left != null) {
            nextLevel.push(curr.left);
          }
        }
      }
      currLevel = nextLevel;
      nextLevel = new Stack<>();
      currOrder = !currOrder;
      result.add(oneLevel);
    }
    return result;
  }
}
