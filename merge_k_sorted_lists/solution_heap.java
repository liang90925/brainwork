/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
    public int compare(ListNode ln1, ListNode ln2) {
      if (ln1 == null) {
        return 1;
      }
      if (ln2 == null) {
        return -1;
      }
      return ln1.val - ln2.val;
    }
  };
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> pQue = new PriorityQueue<>(lists.length, listNodeComparator);

    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) {
        pQue.offer(lists[i]);
      }
    }

    ListNode dummy = new ListNode(-1);
    ListNode pointer = dummy;

    while (!pQue.isEmpty()) {
      ListNode curr = pQue.poll();
      pointer.next = curr;
      pointer = curr;
      if (curr.next != null) {
        pQue.offer(curr.next);
      }
    }
    return dummy.next;
  }
}
