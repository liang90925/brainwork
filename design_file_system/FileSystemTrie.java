import java.util.HashMap;
import java.util.Map;


/**
 * Good thing about the Trie solution is that it's more like the real file systems
 * You will be able to find all the sub directories below a parent branch;
 */

public class FileSystemTrie {
    public class TrieNode {
        String path;
        int value;
        Map<String, TrieNode> subNodes;

        TrieNode(String path, int value) {
            this.path = path;
            this.value = value;
            this.subNodes = new HashMap<>();
        }
    }

    TrieNode root;

    public FileSystemTrie() {
        root = new TrieNode("", -1);
    }

    public boolean createPath(String path, int value) {
        String[] pathArr = path.split("/");
        TrieNode next = root;
        for (int i = 1; i < pathArr.length - 1; i++) {
            String nextPath = pathArr[i];

            if (!next.subNodes.containsKey(nextPath)) {
                return false;

            }
            next = next.subNodes.get(nextPath);
        }

        String newPath = pathArr[pathArr.length - 1];
        if (next.subNodes.containsKey(newPath)) {
            return false;
        }

        TrieNode newNode = new TrieNode(newPath, value);
        next.subNodes.put(newPath, newNode);
        return true;
    }

    public int get(String path) {
        String[] pathArr = path.split("/");
        TrieNode next = root;
        for (int i = 1; i < pathArr.length - 1; i++) {
            String nextPath = pathArr[i];
            if (!next.subNodes.containsKey(nextPath)) {
                return -1;
            }
            next = next.subNodes.get(nextPath);
        }
        return next.value;
    }

    public static void main(String[] args) {
        System.out.println("/a/b".split("/").length);
    }
}
