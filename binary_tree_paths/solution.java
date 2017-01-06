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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    dfs(root, result, "");
    return result;
  }

  private void dfs(TreeNode root, List<String> result, String temp) {
    if (root.left == null && root.right == null) {
      temp += root.val;
      result.add(temp);
    }
    if (root.left != null) {
      dfs(root.left, result, temp + root.val + "->");
    }

    if (root.right != null) {
      dfs(root.right, result, temp + root.val + "->");
    }
  }
}
