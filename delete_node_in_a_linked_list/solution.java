/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // transfer the next nodes val to curr node
 // and point the node to it's next's next
public class Solution {
  public void deleteNode(ListNode node) {
    if (node == null || node.next == null) {
      return;
    }
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
