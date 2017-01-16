/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k <= 0) {
      return head;
    }

    int len = getLen(head);
     k = k % len;

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    head = dummy;

    ListNode newTail = dummy;

    // move head k step
    for (int i = 0; i< k; i++) {
      head = head.next;
    }

    // move head to the end, at the same time move newTail, that means (len - k)
    while (head.next != null) {
      head = head.next;
      newTail = newTail.next;
    }

    // the head should point to next of dummy (original head)
    head.next = dummy.next;
    //dummy's next should point to the next of newTail, which is the new head
    dummy.next = newTail.next;
    // then the newTail's next should point to null
    newTail.next = null;

    // return dummy's next;
    return dummy.next;
  }

  private int getLen(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }
}
