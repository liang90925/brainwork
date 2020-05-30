import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache2 {
  public static class Node {
    private Node prev, next;
    private final int cnt;
    private final LinkedHashSet<Integer> keys = new LinkedHashSet<>();

    public Node(int cnt, int key, Node prev, Node next) {
      this.cnt = cnt;
      this.keys.add(key);
      this.prev = prev;
      this.next = next;
    }
    public Node(int cnt) {
      this.cnt = cnt;
      this.prev = null;
      this.next = null;
    }
  }
  private int capacity = 0;
  private final Node head = new Node(-1);
  private final HashMap<Integer, Integer> keyToValueMap = new HashMap<>();
  private final HashMap<Integer, Node> keyToNodeMap = new HashMap<>();

  // for each key, what do I need to do
  public LFUCache2(int capacity) {
    this.capacity = capacity;
  }

  // In order to have O(1) for get, we need to have a Map<Key, Value??>
  public int get(int key) {
    if (!keyToValueMap.containsKey(key)) {
      return -1;
    }
    moveNode(key);

    return keyToValueMap.get(key);
  }

  private void moveNode(int key) {
    Node theNode = keyToNodeMap.get(key);
    // remove the key from the keys list, since it's count it not the current count any more
    theNode.keys.remove(key);

    // When theNode is the last one
    if (theNode.next == null) {
      theNode.next = new Node(theNode.cnt + 1, key, theNode, null);
    } else if (theNode.next.cnt == theNode.cnt + 1) {
      // When next of theNode has the count +1, put key to the keys
      theNode.next.keys.add(key);
    } else {
      // Need to created a new node and add it between theNode and the next of theNode
      Node newNode = new Node(theNode.cnt + 1, key, theNode, theNode.next);
      theNode.next.prev = newNode;
      theNode.next = newNode;
    }
    keyToNodeMap.put(key, theNode.next);

    // Need to check if after removing the key from theNode, are there any other keys in there
    // If not, need to remove theNode from the linked list
    if (theNode.keys.isEmpty()) {
      removeEmptyNode(theNode);
    }
  }

  private void removeEmptyNode(Node node) {
    node.prev.next = node.next;
    if (node.next != null) {
      node.next.prev = node.prev;
    }
  }

  private void removeLFNode() {
    Node toDelete = head.next;

    int oldestKey = toDelete.keys.iterator().next();
    toDelete.keys.remove(oldestKey);

    if (toDelete.keys.isEmpty()) {
      removeEmptyNode(toDelete);
    }

    keyToNodeMap.remove(oldestKey);
    keyToValueMap.remove(oldestKey);
  }

  public void addNode(int key, int value) {
    if (head.next == null) {
      head.next = new Node(1, key, head, null);
    } else {
      if (head.next.cnt == 1) {
        head.next.keys.add(key);
      } else {
        Node node = new Node(1, key, head, head.next);
        head.next.prev = node;
        head.next = node;
      }
    }
    keyToNodeMap.put(key, head.next);
    keyToValueMap.put(key, value);
  }


  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    // Key already in the map
    if (keyToValueMap.containsKey(key)) {
      moveNode(key);
      keyToValueMap.put(key, value);
    } else {
      // When capacity is full, remove a node first;
      if (keyToValueMap.size() >= capacity) {
        removeLFNode();
      }
      // Add Node
      addNode(key, value);
    }
  }

  public static void main(String[] args) {
    LFUCache2 obj = new LFUCache2(2);
    obj.put(1, 1);
    obj.put(2, 2);
    System.out.println(obj.get(1));
    //System.out.println(obj.get(2));
    obj.put(3, 3);
    System.out.println(obj.get(2));
    System.out.println(obj.get(3));
    obj.put(4, 4);
    System.out.println(obj.get(1));
   // System.out.println(obj.get(2));
    obj.get(3);
    System.out.println(obj.get(3));
    System.out.println(obj.get(4));

    System.out.println("=================");
    // another corner case test when capacity == 0
    LFUCache2 obj1 = new LFUCache2(0);
    obj1.put(0, 0);
    // this should return -1;
    System.out.println(obj1.get(0));

    System.out.println("=================");

    // another corner case test when capacity == 0
    LFUCache2 obj3= new LFUCache2(1);
    obj3.put(2, 1);
    // this should return -1;
    System.out.println(obj3.get(2));
    obj3.put(3, 2);
    System.out.println(obj3.get(2));
    System.out.println(obj3.get(3));

    System.out.println("=================");

    // another corner case test when capacity == 0
    LFUCache2 obj4= new LFUCache2(2);
    System.out.println(obj4.get(2));
    obj4.put(2, 6);
    System.out.println(obj4.get(1));
    obj4.put(1, 5);
    obj4.put(1, 2);
    System.out.println(obj4.get(1));
    System.out.println(obj4.get(2));

  }
}
