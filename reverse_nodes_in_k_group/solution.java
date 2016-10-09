/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k <= 1) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null) {
      head = reverseNextK(head, k);
    }
    return dummy.next;
  }

  private ListNode reverseNextK(ListNode head, int k) {
    // check if there is enough node for reverse
    ListNode checkNode = head;
    for (int i = 0; i < k; i++) {
      if (checkNode.next == null) {
        return checkNode;
      }
      checkNode = checkNode.next;
    }

    // reverse k linked list
    // p1 to store the first node after head,
    // which will be used to point to the new node it suppost to point to after reverse;
    ListNode p1 = head.next;
    // prev to all ways store the larger node in the k list,
    // which will be used to be pointed by head
    ListNode prev = head;
    // curr will be the moving node
    ListNode curr = p1;
    for (int i = 0; i < k; i++) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    p1.next = curr;
    head.next = prev;
    return p1;
  }
}
