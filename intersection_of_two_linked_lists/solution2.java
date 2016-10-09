// use two trace node and two other node to note the tail.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode aTrace = headA;
    ListNode bTrace = headB;
    ListNode tailA = null;
    ListNode tailB = null;

    while (true) {
      if (aTrace == null) {
        aTrace = headB;
      }
      if (bTrace == null) {
        bTrace = headA;
      }
      if (aTrace.next == null) {
        tailA = aTrace;
      }
      if (bTrace.next == null) {
        tailB = bTrace;
      }
      if (tailA != null && tailB != null && tailA != tailB) {
        return null;
      }
      if (aTrace == bTrace) {
        return aTrace;
      }
      aTrace = aTrace.next;
      bTrace = bTrace.next;
    }
  }
}
