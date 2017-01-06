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
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()) {
      int size = que.size();
      int[] values = new int[size];
      for (int i = 0; i < size; i++) {
        TreeNode curr = que.poll();
        values[i] = curr == null ? -1 : curr.val;
        if (curr != null) {
          que.offer(curr.left);
          que.offer(curr.right);
        }
      }
      for (int i = 0; i < size / 2; i++) {
        if (values[i] != values[size - i - 1]) {
          return false;
        }
      }
    }
    return true;
  }
}
