import java.util.*;

public class InMemoryFileSystem {
    public class Node {
        String content;
        Boolean isDirectory;
        Map<String, Node> subs;

        // For dir path
        Node () {
            this.content = null;
            this.isDirectory = true;
            this.subs = new HashMap<>();
        }

        // For file path
        Node (String content) {
            this.content = content;
            this.isDirectory = false;
            this.subs = new HashMap<>();
        }

        // Add content to file path
        public void addContent(String content) {
            this.content += content;
        }
    }

    Node root;
    public InMemoryFileSystem() {
        this.root = new Node();
    }

    public List<String> ls(String path) {
        Node curr = root;
        String[] pathArr = path.split("/");
        for (int i = 1; i <  pathArr.length; i++) {
            String subPath = pathArr[i];
            if (!curr.subs.containsKey(subPath)) {
                return Collections.emptyList();
            }
            curr = curr.subs.get(subPath);
        }
        if (curr.isDirectory) {
            List<String> result = new ArrayList<>(curr.subs.keySet());
            java.util.Collections.sort(result);
            return result;
        }

        return Collections.singletonList(pathArr[pathArr.length - 1]);
    }

    public void mkdir(String path) {
        Node curr = root;
        String[] pathArr = path.split("/");
        for (int i = 1; i <  pathArr.length; i++) {
            String subPath = pathArr[i];
            if (!curr.subs.containsKey(subPath)) {
                Node node = new Node();
                curr.subs.put(subPath, node);
            }
            curr = curr.subs.get(subPath);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Node curr = root;
        String[] pathArr = filePath.split("/");
        for (int i = 1; i <  pathArr.length - 1; i++) {
            String subPath = pathArr[i];
            if (!curr.subs.containsKey(subPath)) {
                Node node = new Node();
                curr.subs.put(subPath, node);
            }
            curr = curr.subs.get(subPath);
        }

        String fileName = pathArr[pathArr.length - 1];
        if (curr.subs.containsKey(fileName)) {
            curr.subs.get(fileName).addContent(content);
        } else {
            Node node = new Node(content);
            curr.subs.put(fileName, node);
        }
    }

    public String readContentFromFile(String filePath) {
        Node curr = root;
        String[] pathArr = filePath.split("/");
        for (int i = 1; i <  pathArr.length; i++) {
            String subPath = pathArr[i];
            if (!curr.subs.containsKey(subPath)) {
                return null;
            }
            curr = curr.subs.get(subPath);
        }

        return curr.content;
    }
}


