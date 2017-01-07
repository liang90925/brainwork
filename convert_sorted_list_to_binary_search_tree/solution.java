/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
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
 // 二分法
public class Solution {
  private ListNode current;
  private int getListLength(ListNode head) {
    int size = 0;
    while (head != null) {
      size++;
      head = head.next;
    }
    return size;
  }

  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }

    current = head;
    int listSize = getListLength(head);
    return sortHelper(listSize);
  }

  private TreeNode sortHelper(int size) {
    if (size <= 0 ) {
      return null;
    }
    TreeNode left = sortHelper(size / 2);

    TreeNode root = new TreeNode(current.val);
    current = current.next;

    TreeNode right = sortHelper(size - size / 2 - 1);

    root.left = left;
    root.right = right;
    return root;
  }
}
