import java.util.HashMap;
import java.util.Map;

public class LRUCacheRewrite {
    public class Item {
        private int key;
        private int value;
        private Item prev;
        private Item next;

        public Item(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    private int capacity;
    private Map<Integer, Item> valueMap = new HashMap<>();
    private Item head = new Item(-1, -1);
    private Item tail = new Item(-1, -1);
    /*
     * @param capacity: An integer
     */public LRUCacheRewrite(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (valueMap.containsKey(key)) {
            Item visitedItem = valueMap.get(key);

            // setup the connect for item before and after the visited node.
            connectPrevAndNext(visitedItem);

            // Move the item to the from of the list;
            addToFront(head, visitedItem);

            return valueMap.get(key).value;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (valueMap.size() == capacity && !valueMap.containsKey(key)) {
            // need to remove the tail one from the LIST;
            int keyTobeDeleted = tail.prev.key;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            // remove keyTobeDeleted from the map
            valueMap.remove(keyTobeDeleted);
        }
        Item newItem;
        if (valueMap.containsKey(key)) {
            newItem = valueMap.get(key);
            newItem.value = value;
            connectPrevAndNext(newItem);
        } else {
            newItem = new Item(key, value);
        }
        // After checking the size and reconnect nodes around the item, add the new item to the front.
        addToFront(head, newItem);

        // Add new item to the Map.
        valueMap.put(key, newItem);
    }

    public void connectPrevAndNext(Item item) {
        item.prev.next = item.next;
        item.next.prev = item.prev;
    }

    public void addToFront(Item head, Item item) {
        item.next = head.next;
        head.next.prev = item;
        head.next = item;
        item.prev = head;
    }

    public static void main(String[] args) {
        LRUCacheRewrite solution = new LRUCacheRewrite(1);
        solution.set(2, 1);
        System.out.println(solution.get(2));
        solution.set(3, 2);
        System.out.println(solution.get(2));
        System.out.println(solution.get(3));
    }
}
