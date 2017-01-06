/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> single = new ArrayList<>();
    dfs(root, single, result, sum);
    return result;
  }
  private void dfs(TreeNode root, List<Integer> single, List<List<Integer>> result, int sum) {
    if (root == null) {
      return;
    }
    sum -= root.val;
    if (root.left == null && root.right == null)  {
      if (sum == 0) {
        single.add(root.val);
        result.add(new ArrayList<>(single));
        single.remove(single.size() - 1);
      }
    }

    single.add(root.val);
    dfs(root.left, single, result, sum);
    dfs(root.right, single, result, sum);
    single.remove(single.size() - 1);

    return;
  }
}
