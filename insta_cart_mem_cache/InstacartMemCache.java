import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InstacartMemCache {

        public static class Item {
            String key;
            String value;
            Long timestamp;
            Item next = null;

            public Item(String key, String value, Long timestamp) {
                this.key = key;
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        public static class Store {
            Map<String, Item> keyToItemMap;
            Map<String, Map<Long, String>> keyToTimestampToValue;

            public Store() {
                this.keyToItemMap = new HashMap<>();
                this.keyToTimestampToValue = new HashMap<>();
            }

            public String get(String key) {
                if (keyToItemMap.containsKey(key)) {
                    return keyToItemMap.get(key).value;
                }
                return null;
            }

            public String get(String key, long timestamp) {
                if (keyToTimestampToValue.containsKey(key)) {
                    Map<Long, String> timeStampToValueMap = keyToTimestampToValue.get(key);

                    Iterator<Long> keySet = timeStampToValueMap.keySet().iterator();
                    long minDiff = Long.MAX_VALUE;
                    String result = null;
                    while(keySet.hasNext()) {
                        long keyTime = keySet.next();
                        if (keyTime <= timestamp) {
                            if (minDiff > timestamp - keyTime) {
                                result = timeStampToValueMap.get(keyTime);
                            }
                        }
                    }
                    return result;
                }
                return null;
            }

            public Long set(String key, String value) {
                long time = System.currentTimeMillis();
                Item newTimestamp = new Item(key, value, time);
                Map<Long, String> timeStampToValueMap = new HashMap<>();

                if (keyToItemMap.containsKey(key)) {
                    Item head = keyToItemMap.get(key);
                    newTimestamp.next = head;

                    timeStampToValueMap = keyToTimestampToValue.get(key);
                }

                keyToItemMap.put(key, newTimestamp);
                timeStampToValueMap.put(time, value);
                keyToTimestampToValue.put(key, timeStampToValueMap);

                return time;
            }
        }

        public static void main(String args[] ) throws Exception {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            Store store = new Store();
            long t1 = store.set("k1", "v1t1");
            System.out.println("t1: " + t1);

            Thread.sleep(10);

            long t2 = store.set("k1", "v1t2");
            System.out.println("t1: " + t2);

            System.out.println(store.get("k1", t1) + " ==== v1t1");
            System.out.println(store.get("k1", t1 + 5) + " ==== v1t1");
            System.out.println(store.get("k1", t1 - 5) + " null");
            System.out.println(store.get("k1") + " ==== v1t2");
            System.out.println("---------------------");

            long t3 = store.set("k1", "v1t3");
            System.out.println("t3: " + t3);
            System.out.println(store.get("k1", t2) + " ==== v1t2");
            System.out.println(store.get("k1") + " ==== v1t3");

            System.out.println("---------------------");

            long t = store.set("k2", "v2t");
            System.out.println("t: " + t);
            System.out.println(store.get("k2", t) + " ==== v2t");
            System.out.println(store.get("k2") + " ==== v2t");
        }
}
