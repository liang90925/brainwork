import java.util.*;

public class PackageDependencyPractice {
    public class Node {
        String name;
        int inDegree;
        int outDegree;
        List<String> children;
        List<String> parents;

        Node(String name) {
            this.name = name;
            this.inDegree = 0;
            this.children = new ArrayList<>();
            this.outDegree = 0;
            this.parents = new ArrayList<>();
        }
    }

    public List<String> getDependenciesFor(String pkg, Map<String, String[]> dependencies) {
        Map<String, Node> nodeMap = new HashMap<>();

        // Build Map
        for (Map.Entry<String, String[]> entry: dependencies.entrySet()) {
            String child = entry.getKey();
            String[] parents = entry.getValue();

            if (!nodeMap.containsKey(child)) {
                nodeMap.put(child, new Node(child));
            }
            nodeMap.get(child).inDegree += parents.length;
            nodeMap.get(child).parents.addAll(new ArrayList<>(Arrays.asList(parents)));

            for (String parent: parents) {
                if (!nodeMap.containsKey(parent)) {
                    nodeMap.put(parent, new Node(parent));
                }
                nodeMap.get(parent).outDegree++;
                nodeMap.get(parent).children.add(child);
            }
        }

        Queue<String> que = new LinkedList<>();
        que.add(pkg);
        int baseDegree = nodeMap.get(pkg).outDegree;

        List<String> results = new ArrayList<>();
        while(!que.isEmpty()) {
            String curr = que.poll();
            for (String parent: nodeMap.get(curr).parents) {
                if (--nodeMap.get(parent).outDegree == baseDegree) {
                    results.add(parent);
                    que.add(parent);
                }
            }
        }

    }
    /**
     *
     * @param dependencies {{A -> [B, C]}, {B -> [D]}} A depends on B, C, B depends on D
     * @return List of String in the ordering of installation
     */
    public List<String> getBuildSequence(Map<String, String[]> dependencies) {
        Map<String, Node> nodeMap = new HashMap<>();

        // Build Map
        for (Map.Entry<String, String[]> entry: dependencies.entrySet()) {
            String child = entry.getKey();
            String[] parents = entry.getValue();

            if (!nodeMap.containsKey(child)) {
                nodeMap.put(child, new Node(child));
            }
            nodeMap.get(child).inDegree += parents.length;

            for (String parent: parents) {
                if (!nodeMap.containsKey(parent)) {
                    nodeMap.put(parent, new Node(parent));
                }
                nodeMap.get(parent).children.add(child);
            }
        }

        Queue<String> que = new LinkedList<>();

        for (Map.Entry<String, Node> entry: nodeMap.entrySet()) {
            if (entry.getValue().inDegree == 0) {
                que.add(entry.getKey());
            }
        }

        List<String> results = new ArrayList<>();
        while (!que.isEmpty()) {
            String curr = que.poll();
            results.add(curr);
            for (String child: nodeMap.get(curr).children) {
                if (--nodeMap.get(child).inDegree == 0) {
                    que.add(child);
                }
            }
        }

        if (results.size() == nodeMap.size()) {
            return results;
        } else {
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        PackageDependencyPractice practice = new PackageDependencyPractice();

        List<String> results = practice.getBuildSequence(
                new HashMap<String, String[]>(){{
                    put("A", new String[]{"B", "C"});
                    put("B", new String[]{"D"});
                    put("D", new String[]{"E", "F"});
                    put("F", new String[]{"G"});
                    put("H", new String[]{"G"});
                }}
        );


        results.forEach(pkg -> System.out.print(pkg + ", "));

    }
}
