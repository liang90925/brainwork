/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode newHead = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = newHead;
      newHead = head;
      head = temp;
    }
    return newHead;
  }
}
