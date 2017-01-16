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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result, 0);
    return result;
  }

  // 利用level来控制，因为right的值是先dfs下去的如果right上相应level有值，就不加left
  // 如果相应level为空，才加left的值
  private void dfs(TreeNode root,  List<Integer> result, int level) {
    if (root == null) {
      return;
    }
    if (level == result.size()) {
      result.add(root.val);
    }
    dfs(root.right, result, level + 1);
    dfs(root.left, result, level + 1);
  }
}
