import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    Map<String, Integer> store;

    public FileSystem() {
        this.store = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (store.containsKey(path)) {
            return false;
        }
        String prev = path.substring(0, path.lastIndexOf("/"));
        if (!prev.isEmpty() && !store.containsKey(prev)) {
            return false;
        }
        store.put(path, value);
        return true;

    }

    public int get(String path) {
        if (store.containsKey(path)) {
            return store.get(path);
        }
        return -1;
    }
}
