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
  private class ResultType {
    int singlePath, maxPath;
    ResultType(int singlePath, int maxPath) {
      this.singlePath = singlePath;
      this.maxPath = maxPath;
    }
  }
  public int maxPathSum(TreeNode root) {
    ResultType resultType = dfs(root);
    return resultType.maxPath;
  }
  private ResultType dfs(TreeNode root) {
    if (root == null) {
      return new ResultType(0, Integer.MIN_VALUE);
    }
    // Divide
    ResultType left = dfs(root.left);
    ResultType right = dfs(root.right);

    // Conquer
    int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
    singlePath = Math.max(singlePath, 0);

    int maxPath = Math.max(left.maxPath, right.maxPath);
    maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

    return new ResultType(singlePath, maxPath);
  }
}
