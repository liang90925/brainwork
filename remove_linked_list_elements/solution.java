/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode pointer = dummy;

    while (head != null) {
      if (head.val != val) {
        pointer.next = head;
        pointer = head;
      }
      head = head.next;
    }
    pointer.next = null;
    return dummy.next;
  }
}
