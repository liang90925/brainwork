/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // find middle
 // reverse tail part
 // check head part and reversed tail part
public class PalindromeLinkedListReverseList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode mid = findMidNode(head);
    ListNode tail = reverseTail(mid.next);

    return checkPalindromeList(head, tail);
  }
  private ListNode findMidNode(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseTail(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = prev;
      prev = head;
      head = temp;
    }
    return prev;
  }

  private boolean checkPalindromeList(ListNode head1, ListNode head2) {
    while (head1 != null && head2 != null) {
      if (head1.val != head2.val) {
          return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }
    return true;
  }
}
