import java.util.ArrayList;
import java.util.List;

public class LongestPathOnTheTree {
    public class Node {
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
    }

    public class ResultType {
        int maxSinglePath;
        int maxCrossPath;

        public ResultType(int maxSinglePath, int maxCrossPath) {
            this.maxSinglePath = maxSinglePath;
            this.maxCrossPath = maxCrossPath;
        }
    }

    /**
     * @param n: The number of nodes
     * @param starts: One point of the edge
     * @param ends: Another point of the edge
     * @param lens: The length of the edge
     * @return: Return the length of longest path on the tree.
     */
    public int longestPath(int n, int[] starts, int[] ends, int[] lens) {
        // Write your code here

        List<List<Node>> nodes = new ArrayList<>();
        // Initiate nodes list;
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        // Build the Graph of Nodes
        for (int i = 0; i < starts.length; i++) {
            nodes.get(starts[i]).add(new Node(starts[i], ends[i], lens[i]));
            nodes.get(ends[i]).add(new Node(ends[i], starts[i], lens[i]));
        }

        ResultType resultType = dfs(0, -1, nodes);
        return resultType.maxCrossPath;
    }

    private ResultType dfs(int node, int parent, List<List<Node>> nodes) {
        int maxCross = 0;
        int maxSingle = 0;

        int maxChildSingle = 0;
        int secondMaxChildSingle = 0;

        List<Node> children = nodes.get(node);
        for (Node child: children) {
            if (child.end == parent) {
                continue;
            }
            ResultType childPath = dfs(child.end, node, nodes);
            childPath.maxSinglePath += child.dist;

            maxCross = Math.max(childPath.maxCrossPath, maxCross);
            maxSingle = Math.max(childPath.maxSinglePath, maxSingle);

            int temp = maxChildSingle;
            if (maxSingle > maxChildSingle) {
                maxChildSingle = maxSingle;
                secondMaxChildSingle = temp;
            } else if (maxSingle > secondMaxChildSingle) {
                secondMaxChildSingle = maxSingle;
            }
        }
        maxCross = Math.max(maxChildSingle + secondMaxChildSingle, maxSingle);
        return new ResultType(maxSingle, maxCross);
    }
}
