import java.util.HashMap;

public class LRUCache {
  private class Node {
    Node prev;
    Node next;
    int key;
    int value;
    public Node(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }
  private int capacity;
  private HashMap<Integer, Node> keyToNodeMap = new HashMap<>();
  private Node head = new Node(-1, -1);
  private Node tail = new Node(-1, -1);

  public LRUCache(int capacity) {
    // setup capacity;
    // build the list with head and tail connected
    this.capacity = capacity;

    tail.prev = head;
    head.next = tail;
  }

  public int get(int key) {
    if (!keyToNodeMap.containsKey(key)) {
      return -1;
    }
    // remvoe curr from existing linked list
    Node curr = keyToNodeMap.get(key);
    curr.prev.next = curr.next;
    curr.next.prev = curr.prev;
    // insert the node to the tail of the list
    moveToTail(curr);

    return keyToNodeMap.get(key).value;

  }

  public void set(int key, int value) {
    if (keyToNodeMap.containsKey(key)) {
      keyToNodeMap.get(key).value = value;
            // remvoe curr from existing linked list
      Node curr = keyToNodeMap.get(key);
      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
      // insert the node to the tail of the list
      moveToTail(curr);
      return;
    }
    if (keyToNodeMap.size() == capacity) {
      keyToNodeMap.remove(head.next.key);
      head.next = head.next.next;
      head.next.prev = head;
    }
    Node newNode = new Node(key, value);
    keyToNodeMap.put(key, newNode);
    moveToTail(newNode);
  }

  private void moveToTail(Node curr) {
    curr.prev = tail.prev;
    tail.prev = curr;
    curr.prev.next = curr;
    curr.next = tail;
  }
}
