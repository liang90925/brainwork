/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *   int val;
 *   TreeNode left;
 *   TreeNode right;
 *   TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
// int[] array;
// array[0] means the val without chosing root;
// array[1] means the val chosing root;
public class Solution {
  public int rob(TreeNode root) {
    int[] result = dp(root);
    return Math.max(result[0], result[1]);
  }

  public int[] dp(TreeNode root) {
    if (root == null) {
      int[] curr = new int[]{0, 0};
      return curr;
    }
    int[] left = dp(root.left);
    int[] right = dp(root.right);
    int[] curr = new int[2];
    curr[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    curr[1] = root.val + left[0] + right[0];
    return curr;
  }
}
