/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 public class Solution {
   public ListNode oddEvenList(ListNode head) {
     if (head == null) {
       return null;
     }
     ListNode oddHead = head,  odd = oddHead;
     ListNode evenHead = head.next, even = evenHead;

     while (even != null && even.next != null) {
       odd.next = even.next;
       odd = odd.next;
       even.next = odd.next;
       even = even.next;
       odd.next = evenHead;
     }
     return oddHead;
   }
 }

// OR THE FOLLOWING WITH ONE LESS LISTNODE NEEDED.
/*
public class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode odd = head;
    ListNode evenHead = head.next, even = evenHead;

    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
      odd.next = evenHead;
    }
    return head;
  }
}
*/
