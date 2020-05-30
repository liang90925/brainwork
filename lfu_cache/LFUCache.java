import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;

public class LFUCache {
  class Node {
    private Node prev, next;
    private int count;
    private LinkedHashSet<Integer> keys = new LinkedHashSet<>();

    public Node(Node prev, Node next, int count, int key) {
      this.prev = prev;
      this.next = next;
      this.count = count;
      keys.add(key);
    }
  }

  private Node head = null;
  private int capacity;
  private Map<Integer, Integer> valueMap;
  private Map<Integer, Node> nodeMap;
  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.valueMap = new HashMap<>(this.capacity, 1f);
    this.nodeMap = new HashMap<>(this.capacity, 1f);
  }

  public int get(int key) {
   // System.out.println("when get key: " + key);
   // System.out.println("the nodemap count: " + nodeMap.get(key).count);
//    System.out.println("the nodemap keys");
//    for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
//      System.out.println("key: " + entry.getKey() + "; count: " + entry.getValue().count + "; keys: " + entry.getValue().keys);
//    }

    if (valueMap.containsKey(key)) {
      increaseFreq(key);
    }

//    System.out.println("=====after get key " + key + " =====");
//    for (Map.Entry<Integer, Node> entry : nodeMap.entrySet()) {
//      System.out.println("key: " + entry.getKey() + "; count: " + entry.getValue().count + "; keys: " + entry.getValue().keys);
//    }

    return valueMap.getOrDefault(key, -1); // if map contains the key, return the value, if not return -1
  }

  private void increaseFreq(int key) {
    // Find the Node where the key is the input;
    Node freqNode = nodeMap.get(key);

    // since the frequency of the key will be increased by one
    // so need to remove the key from the keylist of the freqNode first;
    freqNode.keys.remove(key);

    // if current freqNode's next is null, create a new node with freq+1 and put it between curr freqnode and null
    // if the next node's freq = current freqNode's freq + 1, just add the key to the keylist of freqNode's next
    // or need to created a new node with freq +1 and add it between freqNode and freqNode's Next;
    if (Objects.isNull(freqNode.next)) {
      freqNode.next = new Node(freqNode, null, freqNode.count + 1, key);
    } else if (freqNode.next.count == freqNode.count + 1) {
      freqNode.next.keys.add(key);
    } else {
      freqNode.next = freqNode.next.prev = new Node(freqNode, freqNode.next, freqNode.count + 1, key);
    }

    // now put the new key and node match to the nodeMap;
    nodeMap.put(key, freqNode.next);

    // at the end, we need to check if curr freqNode's keylist is empty after remove the input key
    // if yes, remove the freqNode with the empty keylist;
    if (freqNode.keys.isEmpty()) {
      removeNodeWithEmptyKeys(freqNode);
    }
  }

  private void removeNodeWithEmptyKeys(Node node) {
    if (head == node) {
      head = node.next;
    } else {
      node.prev.next = node.next;
    }

    // This check is important, don't forget
    if (Objects.nonNull(node.next)) {
      node.next.prev = node.prev;
    }
  }

  public void set(int key, int value) {
    // the situation when capacity == 0 still needs to be taken care of seperately
    if (capacity == 0) {
      return;
    }

    // if the valueMap contains the input key,  increase the freq of the key
    if (valueMap.containsKey(key)) {
      increaseFreq(key);
    } else {
      // when valueMap doesn't contain the key:
      // 1. check if it reached the capcity, remove the LFNode if yes;
      // 2. add the new key to nodeMap with the correct freq count;
      if (valueMap.size() == capacity) {
        removeLFNode();
      }
      addToNodeMap(key);
    }

    // at the end put the key and value pair to valueMap;
    valueMap.put(key, value);
  }

  private void removeLFNode() {
    if (Objects.isNull(head)) {
      return;
    }
    int oldest = head.keys.iterator().next();
    head.keys.remove(oldest);
    if (head.keys.isEmpty()) {
      removeNodeWithEmptyKeys(head);
    }
    nodeMap.remove(oldest);
    valueMap.remove(oldest);
  }

  private void addToNodeMap(int key) {
    if (Objects.isNull(head)) {
      head = new Node(null, null, 1, key);
    } else if (head.count == 1) {
      head.keys.add(key);
    } else {
      head = head.prev = new Node(null, head, 1, key);
    }
    nodeMap.put(key, head);
  }

  public static void main(String[] args) {
    LFUCache obj = new LFUCache(2);
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
    System.out.println(obj.get(3));
    System.out.println(obj.get(4));

    // another corner case test when capacity == 0
    LFUCache obj1 = new LFUCache(0);
    obj1.set(0, 0);
    // this should return -1;
    System.out.println(obj1.get(0));
  }
}
