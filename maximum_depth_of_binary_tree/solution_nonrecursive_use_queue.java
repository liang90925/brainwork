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
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);

    int currNum = 1;
    int nextNum = 0;
    int depth = 0;

    while (!que.isEmpty()) {
      TreeNode currNode = que.poll();
      currNum--;
      if (currNode.left != null) {
        que.offer(currNode.left);
        nextNum++;
      }
      if (currNode.right != null) {
        que.offer(currNode.right);
        nextNum++;
      }
      if (currNum == 0) {
        currNum = nextNum;
        nextNum = 0;
        depth++;
      }
    }
    return depth;
  }
}
