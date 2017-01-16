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
    TreeLinkNode next = root.left;

    //注意while 循环的条件
    while (parent != null &&  next != null) {
      TreeLinkNode prev = null;
      while (parent != null) {
        if (prev == null) {
          prev = parent.left;
        } else {
          prev.next = parent.left;
          prev = prev.next;
        }
        prev.next = parent.right;
        prev = prev.next;
        parent = parent.next;
      }
      parent = next;
      next = parent.left;
    }
  }
}
