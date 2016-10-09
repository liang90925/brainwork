/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
   public ListNode reverseBetween(ListNode head, int m, int n) {
     if (head == null || m >= n) {
       return head;
     }
     ListNode dummy = new ListNode(0);
     dummy.next = head;
     head = dummy;

     for (int i = 1; i < m; i++) {
       head = head.next;
     }
     ListNode preMNode = head;
     ListNode mNode = head.next;
     ListNode nNode = mNode;
     ListNode postNNode = nNode.next;

     for (int i = m; i < n; i++) {
       if (postNNode == null) {
         return null;
       }
       ListNode temp = postNNode.next;
       postNNode.next = nNode;
       nNode = postNNode;
       postNNode = temp;

     }

     mNode.next = postNNode;
     preMNode.next = nNode;

     return dummy.next;
   }
 }
