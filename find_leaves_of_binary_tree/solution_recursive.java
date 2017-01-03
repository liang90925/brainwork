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
  public List<List<Integer>> findLeaves(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    helper(root, result);
    return result;
  }
  private int helper(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
      return -1;
    }
    int left = helper(root.left, result);
    int right = helper(root.right, result);
    int curr = Math.max(left, right) + 1;
    if (result.size() ==  curr) {
      result.add(new ArrayList<>());
    }
    result.get(curr).add(root.val);
    return curr;
  }
}
