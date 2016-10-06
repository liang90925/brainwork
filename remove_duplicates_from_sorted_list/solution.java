/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// this is a simpler version with only one pointer
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode pointer = head;
    while (pointer.next != null) {
      if (pointer.val == pointer.next.val) {
        pointer.next = pointer.next.next;
      } else {
        pointer = pointer.next;
      }
    }
    return head;
  }
}


 public class Solution {
   public ListNode deleteDuplicates(ListNode head) {
     if (head == null) {
       return head;
     }
     ListNode pointer1 = head;
     ListNode pointer2 = head.next;
     while (pointer2 != null) {
       if (pointer1.val == pointer2.val) {
         pointer2 = pointer2.next;
       } else {
         pointer1.next = pointer2;
         pointer1 = pointer2;
         pointer2 = pointer2.next;

       }
     }
     pointer1.next = pointer2;
     return head;
   }
 }
