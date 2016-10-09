// use two Trace node and
// use a counter to count the number of times that the two list meets end;

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
    int meetEnd = 0;
    while (aTrace != bTrace && meetEnd <= 2) {
      if (aTrace == null) {
        aTrace = headB;
        meetEnd++;
      }
      if (bTrace == null) {
        bTrace = headA;
        meetEnd++;
      }
      if (aTrace == bTrace) {
        return aTrace;
      }
      aTrace = aTrace.next;
      bTrace = bTrace.next;
    }
    return aTrace;
  }
}
