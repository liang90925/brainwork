import java.util.*;

public class CourseScheduleIVLeet {
    private List<List<Integer>> courses = new ArrayList<>();
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        for (int i = 0; i < n; i++) {
            courses.add(new ArrayList<>());
        }

        // Build the graph;
        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[0]).add(prerequisite[1]);
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] pair : queries) {
            boolean found = bfs(courses, pair[0], pair[1]);
            result.add(found);
        }

        return result;
    }

    private boolean bfs(List<List<Integer>> courses, int source, int destination) {
        boolean visited[] = new boolean[courses.size()];

        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        visited[source] = Boolean.TRUE;
        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int child: courses.get(cur)) {
                if(child == destination) {
                    return true;
                }
                if (!visited[child]) {
                    que.add(child);
                    visited[child] = true;
                }
            }
        }

        return false;
    }
}
