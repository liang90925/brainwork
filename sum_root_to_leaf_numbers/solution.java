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
  public int sumNumbers(TreeNode root) {
    if (root == null || root.val == 0) {
      return 0;
    }
    dfs(root, 0);
  }

  private int dfs(TreeNode node, int prev) {
    if (node == null) {
      return 0;
    }
    // NOTE!!!: 关键在这里， 利用pre往下传递值
    int sum = root.val + prev * 10;
    if (root.left == null && root.right == null) {
      return sum;
    }

    return dfs(root.left, sum) + dfs(root.right, sum);
  }
}
