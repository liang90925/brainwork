// This version has no global variable that changes

public class CourseScheduleIVV2 {
    int numCourse;
    /**
     * @param n: an integer, denote the number of courses
     * @param p: a list of prerequisite pairs
     * @return: return an integer,denote the number of topologicalsort
     */
    public int topologicalSortNumber(int n, int[][] p) {
        // Write your code here
        this.numCourse = n;
        int[] inDegree = new int[n];
        boolean[] visited = new boolean[n];
        boolean[][] preReq = new boolean[n][n];

        for (int[] courses : p) {
            preReq[courses[1]][courses[0]] = true;
            inDegree[courses[0]] += 1;
        }

        return dfs(0, preReq, inDegree, visited, 0);
    }

    private int dfs(int level, boolean[][] preReq, int[] inDegree, boolean[] visited, int result) {
        if (level == numCourse) {
            result++;
            return result;
        }
        for (int i = 0; i < numCourse; i++) {
            if (inDegree[i] == 0 && !visited[i]) {
                visited[i] = true;
                for (int j = 0; j < numCourse; j++) {
                    if (preReq[i][j]) {
                        inDegree[j]--;
                    }
                }

                result = dfs(level + 1, preReq, inDegree, visited, result);

                for (int j = 0; j < numCourse; j++) {
                    if (preReq[i][j]) {
                        inDegree[j]++;
                    }
                }
                visited[i] = false;
            }
        }
        return result;
    }
}
