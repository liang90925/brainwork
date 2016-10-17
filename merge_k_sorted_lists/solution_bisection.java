/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return mergeHelper(lists, 0, lists.length - 1);
  }

  private ListNode mergeHelper(ListNode[] lists, int start, int end) {
    if (start == end) {
      return lists[start];
    }
    int mid = start + (end - start) / 2;
    ListNode left = mergeHelper(lists, start, mid);
    ListNode right = mergeHelper(lists, mid + 1, end);
    return mergeTwoSortedList(left, right);
  }

  private ListNode mergeTwoSortedList(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(-1);
    ListNode pointer = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        pointer.next = left;
        left = left.next;
      } else {
        pointer.next = right;
        right = right.next;
      }
      pointer = pointer.next;
    }
    if (left != null) {
      pointer.next = left;
    }
    if (right != null) {
      pointer.next = right;
    }
    return dummy.next;
  }
}
