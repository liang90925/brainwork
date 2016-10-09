/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// with two pointers
public class Solution {
 public ListNode swapPairs(ListNode head) {
   if (head == null || head.next == null) {
     return head;
   }

   ListNode dummy = new ListNode(0);
   ListNode p1 = dummy;
   p1.next = head;
   ListNode p2 = head;

   while (p2 != null && p2.next != null) {
     p1.next = p2.next;
     p2.next = p2.next.next;
     p1.next.next = p2;

     p1 = p2;
     p2 = p2.next;
   }
   return dummy.next;
 }
}

// with three pointers
public class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    ListNode p1 = dummy;
    p1.next = head;
    ListNode p2 = head;
    ListNode p3 = p2.next;

    while (p2 != null && p3 != null) {
      p1.next = p3;
      p2.next = p3.next;
      p3.next = p2;

      p1 = p2;
      p2 = p2.next;
      if (p2 == null) {
        continue;
      }
      p3 = p2.next;
    }
    return dummy.next;
  }
}
