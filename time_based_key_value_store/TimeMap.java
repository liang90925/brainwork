import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    Map<String, TreeMap<Integer, String>> storage;

    /** Initialize your data structure here. */
    public TimeMap() {
        this.storage = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!storage.containsKey(key)) {
            storage.put(key, new TreeMap<>());
        }
        storage.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!storage.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = storage.get(key);
        Integer closestTimestamp = treeMap.floorKey(timestamp);
        return closestTimestamp == null ? "" : treeMap.get(closestTimestamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */