import java.util.*;

public class LFUCacheRewrite {
  public class Node {
    int cnt;
    Node pre;
    Node next;
    LinkedList<Integer> keys = new LinkedList<>();
    public Node(int cnt, Node pre, Node next, int key) {
      this.cnt = cnt;
      this.pre = pre;
      this.next = next;
      this.keys.add(key);
    }

    public Node(int cnt, Node pre, Node next) {
      this.cnt = cnt;
      this.pre = pre;
      this.next = next;
    }
    public Node(int cnt) {
      this.cnt = cnt;
    }
  }

  private int capacity;
  private Node head = new Node(-1);
  private Map<Integer, Integer> keyToValueMap = new HashMap<>();
  private Map<Integer, Node> keyToNodeMap = new HashMap<>();

  // for each key, what do I need to do
  public LFUCacheRewrite(int capacity) {
    this.capacity = capacity;
  }

  // In order to have O(1) for get, we need to have a Map<Key, Value??>
  public int get(int key) {
    if (!keyToValueMap.containsKey(key)) {
      return -1;
    }
    moveNodeForward(key);

    return keyToValueMap.get(key);
  }

  public void moveNodeForward(int key) {
    Node node = keyToNodeMap.get(key);
    if (node.next == null) {
      // 需要加新点
      Node newNode = new Node(node.cnt + 1, node, null, key);
      node.next = newNode;
    } else if (node.next.cnt == node.cnt + 1){
      node.next.keys.add(key);
    } else {
      Node newNode = new Node(node.cnt + 1, node, node.next, key);
      node.next.pre = newNode;
      node.next = newNode;
    }

    node.keys.remove(Integer.valueOf(key));
    keyToNodeMap.remove(key);
    keyToNodeMap.put(key, node.next);

    if (node.keys.isEmpty()) {
      removeNode(node);
    }
  }

  private void removeNode(Node node) {
    node.pre.next = node.next;
    if (node.next != null) {
      node.next.pre = node.pre;
    }
  }

  public void set(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToValueMap.containsKey(key)) {
      keyToValueMap.put(key, value);
      moveNodeForward(key);
      return;
    }

    if (keyToValueMap.size() >= capacity) {
      // Need to remove one node;
      removeAnItem();
    }

    addNode(key, value);
  }

  private void addNode(int key, int value) {
    if (head.next == null) {
      Node node = new Node(1, head, null, key);
      head.next = node;
    } else if (head.next.cnt == 1) {
      head.next.keys.add(key);
    } else {
      Node node = new Node(1, head, head.next, key);
      head.next.pre = node;
      head.next = node;
    }

    keyToNodeMap.put(key, head.next);
    keyToValueMap.put(key, value);

  }

  private void removeAnItem() {
    Node node = head.next;
    if (node != null && !node.keys.isEmpty()) {
      int key = node.keys.removeFirst();
      keyToValueMap.remove(key);
      keyToNodeMap.remove(key);
      if (node.keys.isEmpty()) {
        removeNode(node);
      }
    }
  }

  public static void main(String[] args) {
    LFUCacheRewrite obj = new LFUCacheRewrite(2);
    obj.set(1, 1);
    obj.set(2, 2);
    System.out.println(obj.get(1));
    //System.out.println(obj.get(2));
    obj.set(3, 3);
    System.out.println(obj.get(2));
    System.out.println(obj.get(3));
    obj.set(4, 4);
    System.out.println(obj.get(1));
   // System.out.println(obj.get(2));
    obj.get(3);
    System.out.println(obj.get(3));
    System.out.println(obj.get(4));

    System.out.println("=================");
    // another corner case test when capacity == 0
    LFUCacheRewrite obj1 = new LFUCacheRewrite(0);
    obj1.set(0, 0);
    // this should return -1;
    System.out.println(obj1.get(0));

    System.out.println("=================");

    // another corner case test when capacity == 0
    LFUCacheRewrite obj3= new LFUCacheRewrite(1);
    obj3.set(2, 1);
    // this should return -1;
    System.out.println(obj3.get(2));
    obj3.set(3, 2);
    System.out.println(obj3.get(2));
    System.out.println(obj3.get(3));

    System.out.println("=================");

    // another corner case test when capacity == 0
    LFUCacheRewrite obj4= new LFUCacheRewrite(2);
    System.out.println(obj4.get(2));
    obj4.set(2, 6);
    System.out.println(obj4.get(1));
    obj4.set(1, 5);
    obj4.set(1, 2);
    System.out.println(obj4.get(1));
    System.out.println(obj4.get(2));

  }
}
