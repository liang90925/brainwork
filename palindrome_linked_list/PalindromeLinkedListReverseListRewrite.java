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
// This solution has 0(N) time complexity and O(1) space complexity
public class PalindromeLinkedListReverseListRewrite {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  public boolean isPalindrome(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
      return true;
    }

    ListNode midNode = findMidNode(head);
    ListNode reversedSecondHead = reverseLinkedList(midNode.next);
    ListNode dummyFirst = head;
    ListNode dummySecnd = reversedSecondHead;

    boolean isPalindrome = checkPalindromeList(dummyFirst, dummySecnd);

    // Reverse back so that the original input will not be changed
    midNode.next = reverseLinkedList(reversedSecondHead);

    return isPalindrome;
  }

  private ListNode findMidNode(ListNode head) {
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private ListNode reverseLinkedList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode dummy = head.next;
      head.next = newHead;
      newHead = head;
      head = dummy;
    }
    return newHead;
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
