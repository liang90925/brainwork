/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// this simple version is better
public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }
    if (q == null) {
      return p == null;
    }
    if (p.val != q.val) {
      return false;
    }
    if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
      return false;
    }
    return true;
  }
}

public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }
    if (q == null) {
      return p == null;
    }
    if (p.val != q.val) {
      return false;
    }
    return dfs(p.left, q.left) && dfs(p.right, q.right);
  }
  private boolean dfs(TreeNode p, TreeNode q) {
    if (p == null) {
      return q == null;
    }
    if (q == null) {
      return p == null;
    }
    if (p.val != q.val) {
      return false;
    }

    if (!dfs(p.left, q.left) || !dfs(p.right, q.right)) {
      return false;
    }
    return true;
  }
}
