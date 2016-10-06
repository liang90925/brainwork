/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 // use Hashmap
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();

    RandomListNode dummyHead = new RandomListNode(0);
    RandomListNode pointer = dummyHead;
    RandomListNode newHead;

    while (head != null) {
      if (nodeMap.containsKey(head)) {
        newHead = nodeMap.get(head);
      } else {
        newHead = new RandomListNode(head.label);
        nodeMap.put(head, newHead);
      }
      pointer.next = newHead;

      if (head.random != null) {
        if (nodeMap.containsKey(head.random)) {
          newHead.random = nodeMap.get(head.random);
        } else {
          newHead.random = new RandomListNode(head.random.label);
          nodeMap.put(head.random, newHead.random);
        }
      }
      pointer = newHead;
      head = head.next;
    }
    return dummyHead.next;
  }
}
