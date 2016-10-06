/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
   public ListNode deleteDuplicates(ListNode head) {
     if (head == null || head.next == null) {
       return head;
     }

     ListNode dummyHead = new ListNode(0);
     dummyHead.next = head;
     head = dummyHead;

     while (head.next != null && head.next.next!= null) {
       if (head.next.val != head.next.next.val) {
         head = head.next;
       } else {
         int value = head.next.val;
         while (head.next != null && head.next.val == value) {
          head.next = head.next.next;
         }
       }
     }
     return dummyHead.next;
   }
 }
