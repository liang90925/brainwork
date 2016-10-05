/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *       val = x;
 *       next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null) {
      return null;
    }
    ListNode head = new ListNode(0);
    ListNode pointer = head;

    int carry = 0;
    while (l1 != null && l2 != null) {
      int sum = (l1.val + l2.val + carry);
      pointer.next = new ListNode(sum % 10);
      carry = sum / 10;
      pointer = pointer.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      int sum = (l1.val + carry);
      pointer.next = new ListNode(sum % 10);
      carry = sum / 10;
      pointer = pointer.next;
      l1 = l1.next;
    }
    while (l2 != null) {
      int sum = (l2.val + carry);
      pointer.next = new ListNode(sum % 10);
      carry = sum / 10;
      pointer = pointer.next;
      l2 = l2.next;
    }
    if (carry != 0) {
      pointer.next = new ListNode(carry);
    }
    return head.next;
  }
}
