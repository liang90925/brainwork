/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 层层遍历，use queue 存每层的点，每次只拿左右的点，
public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);
    while (!que.isEmpty()) {
      //千万要注意此处size一定要单独领出来，因为size会在que poll的过程中变化
      int size = que.size();
      for (int i = 0; i < size; i++) {

        TreeNode curr = que.poll();
        // everytime, we add right then left, so when i = 0, it must be the right view from the level.
        if (i == 0) {
          result.add(curr.val);
        }
        if (curr.right != null) {
          que.offer(curr.right);
        }
        if (curr.left != null) {
          que.offer(curr.left);
        }
      }
    }
    return result;
  }
}
