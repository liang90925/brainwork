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
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int depth = 1;
    Queue<TreeNode> que = new LinkedList<>();
    que.add(root);

    int currNum = 1;
    int nextNum = 0;

    while (!que.isEmpty()) {
      TreeNode curr = que.poll();
      currNum--;
      if (curr.left == null && curr.right == null) {
        return depth;
      }

      if (curr.left != null) {
        que.add(curr.left);
        nextNum++;
      }
      if (curr.right != null) {
        que.add(curr.right);
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
