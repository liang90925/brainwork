import java.util.*;

public class InMemoryFileSystemTwoMaps {
    public static class Node {
        Map<String, String> files;
        Map<String, Node> dirs;

        // For dir path
        Node () {
            this.files = new HashMap<>();
            this.dirs = new HashMap<>();
        }

        public void addContent(String filePath, String content) {
            files.put(filePath, files.get(filePath) + content);
        }
    }

    Node root;

    public InMemoryFileSystemTwoMaps() {
        this.root = new Node();
    }

    public List<String> ls(String path) {
        Node curr = root;
        String[] pathArr = path.split("/");
        for (int i = 1; i <  pathArr.length; i++) {
            String subPath = pathArr[i];
            if (curr.files.containsKey(subPath)) {
                return Collections.singletonList(subPath);
            }

            if (curr.dirs.containsKey(subPath)) {
                curr = curr.dirs.get(subPath);
            } else {
                return Collections.emptyList();
            }
        }

        List<String> result = new ArrayList<>(curr.dirs.keySet());
        result.addAll(curr.files.keySet());
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        Node curr = root;
        String[] pathArr = path.split("/");
        for (int i = 1; i <  pathArr.length; i++) {
            String subPath = pathArr[i];
            if (!curr.dirs.containsKey(subPath)) {
                Node node = new Node();
                curr.dirs.put(subPath, node);
            }
            curr = curr.dirs.get(subPath);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Node curr = root;
        String[] pathArr = filePath.split("/");
        for (int i = 1; i <  pathArr.length - 1; i++) {
            String subPath = pathArr[i];
            if (!curr.dirs.containsKey(subPath)) {
                Node node = new Node();
                curr.dirs.put(subPath, node);
            }
            curr = curr.dirs.get(subPath);
        }

        String fileName = pathArr[pathArr.length - 1];
        if (curr.files.containsKey(fileName)) {
            curr.addContent(fileName, content);
        } else {
            curr.files.put(fileName, content);
        }
    }

    public String readContentFromFile(String filePath) {
        Node curr = root;
        String[] pathArr = filePath.split("/");
        for (int i = 1; i <  pathArr.length - 1; i++) {
            String subPath = pathArr[i];
            if (!curr.dirs.containsKey(subPath)) {
                return null;
            }
            curr = curr.dirs.get(subPath);
        }
        return curr.files.getOrDefault(pathArr[pathArr.length - 1], null);
    }
}


