import java.util.HashMap;
import java.util.Map;

public class Memcache {
    public class Data {
        private int value;
        private int expireAt;

        public Data() {}
        public Data(int value, int expireAt) {
            this.value = value;
            this.expireAt = expireAt;
        }
        public Data setValue(int value) {
            this.value = value;
            return this;
        }
        public Data setExpiredAt(int expireAt) {
            this.expireAt = expireAt;
            return this;
        }
    }
    Map<Integer, Data> keyToDataMap = new HashMap<>();
    private static final int MAX = Integer.MAX_VALUE;

    public Memcache() {
        // do intialization if necessary
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!keyToDataMap.containsKey(key)) {
            return MAX;
        }
        Data data = keyToDataMap.get(key);
        if (data.expireAt == -1 || data.expireAt >= curtTime) {
            return data.value;
        }
        return MAX;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        Data data;
        if (!keyToDataMap.containsKey(key)) {
            data = keyToDataMap.get(key);
        }
        data = new Data(value, ttl == 0 ? -1 : curtTime + ttl - 1);
        keyToDataMap.put(key, data);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (keyToDataMap.containsKey(key)) {
            keyToDataMap.remove(key);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        // write your code here
        if (!keyToDataMap.containsKey(key)) {
            return MAX;
        }
        Data data = keyToDataMap.get(key);
        if (data.expireAt == -1 || data.expireAt >= curtTime) {
            data.setValue(data.value + delta);
            keyToDataMap.put(key, data);
            return data.value;
        }
        return MAX;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        if (!keyToDataMap.containsKey(key)) {
            return MAX;
        }
        Data data = keyToDataMap.get(key);
        if (data.expireAt == -1 || data.expireAt >= curtTime) {
            data.setValue(data.value - delta);
            keyToDataMap.put(key, data);
            return data.value;
        }
        return MAX;
    }
}
