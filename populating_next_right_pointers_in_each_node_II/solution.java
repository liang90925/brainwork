/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null || (root.right == null && root.left == null)) {
      return;
    }
    TreeLinkNode parent = root;
    TreeLinkNode next;
    TreeLinkNode prev;

    while (parent != null) {
      next = null;
      prev = null;
      while (parent != null) {
          if (next == null) {
            next = parent.left != null ? parent.left : parent.right;
          }
          if (parent.left != null) {
            if (prev != null) {
              prev.next = parent.left;
              prev = prev.next;
            } else {
              prev = parent.left;
            }
          }
          if (parent.right != null) {
            if (prev != null) {
              prev.next = parent.right;
              prev = prev.next;
            } else {
              prev = parent.right;
            }
          }
          parent = parent.next;
        }
      parent = next;
    }

  }
}
