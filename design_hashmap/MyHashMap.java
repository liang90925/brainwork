

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private static final int SPACE = 2069;
    private final List<Bucket> map = new ArrayList<>();

    /** Initialize your data structure here. */
    public MyHashMap() {
        for (int i = 0; i < SPACE; i++) {
            this.map.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = key % SPACE;
        map.get(idx).put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = key % SPACE;
        return map.get(idx).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = key % SPACE;
        map.get(idx).remove(key);
    }


    public static class Bucket {
        private final List<KeyValue<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public int get(int key) {
            for (KeyValue<Integer, Integer> item: bucket) {
                if (item.key.equals(key)) {
                    return item.value;
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            boolean found = false;
            for (KeyValue<Integer, Integer> item: bucket) {
                if (item.key.equals(key)) {
                    item.value = value;
                    found = true;
                }
            }
            if (!found) {
                bucket.add(new KeyValue<>(key, value));
            }
        }

        public void remove(int key) {
            for (KeyValue<Integer, Integer> item: bucket) {
                if (item.key.equals(key)) {
                    bucket.remove(item);
                    break;
                }
            }
        }
    }

    public static class KeyValue<K, V> {
        K key;
        V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

/*
Complexity Analysis

Time Complexity: for each of the methods, the time complexity is O(N/K)
where N is the number of all possible keys
and K is the number of predefined buckets in the hashmap, which is 2069 in our case.
In the ideal case, the keys are evenly distributed in all buckets.
As a result, on average, we could consider the size of the bucket is N/K.
worst case we need to iterate through a bucket to find the desire value, the time complexity of each method is O(N/K)

Space Complexity: O(K+M)
where K is the number of predefined buckets in the hashmap
and M is the number of unique keys that have been inserted into the hashmap.

 */
