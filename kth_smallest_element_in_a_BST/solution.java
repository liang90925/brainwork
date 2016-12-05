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
**/
import java.util.*;

// non-recursive solution
// use Binary search tree inorder traverse

public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    if (root == null || k <= 0) {
      return -1;
    }
    Stack<TreeNode> stc = new Stack<>();
    TreeNode p = root;
    int cnt = 0;
    while (p != null || !stc.isEmpty()) {
      while (p != null) {
        stc.push(p);
        p = p.left;
      }
      p = stc.pop();
      cnt++;
      if (cnt == k) {
        return p.val;
      }
      p = p.right;
    }
    return -1;
  }
}
