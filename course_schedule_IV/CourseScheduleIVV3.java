// This version combined the preReq[][] and inDegree[] into one class Course

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIVV3 {
    int numCourse;
    public class Course {
        int inDegree;
        List<Integer> dependingCourses;

        public Course(int inDegree, List<Integer> dependingCourses) {
            this.inDegree = inDegree;
            this.dependingCourses = dependingCourses;
        }
    }
    /**
     * @param n: an integer, denote the number of courses
     * @param p: a list of prerequisite pairs
     * @return: return an integer,denote the number of topologicalsort
     */
    public int topologicalSortNumber(int n, int[][] p) {
        // Write your code here
        this.numCourse = n;
        boolean[] visited = new boolean[n];
        Course[] courses = new Course[numCourse];

        for (int i = 0; i < n; i++) {
            courses[i] = new Course(0, new ArrayList<>());
        }

        for (int[] pre : p) {
            courses[pre[0]].inDegree++;
            courses[pre[1]].dependingCourses.add(pre[0]);
        }

        return dfs(0, courses, visited, 0);
    }

    private int dfs(int level, Course[] courses, boolean[] visited, int result) {
        if (level == numCourse) {
            result++;
            return result;
        }
        for (int i = 0; i < numCourse; i++) {
            if (courses[i].inDegree == 0 && !visited[i]) {
                visited[i] = true;
                for (int dep: courses[i].dependingCourses) {
                    courses[dep].inDegree--;
                }

                result = dfs(level + 1, courses, visited, result);

                for (int dep: courses[i].dependingCourses) {
                    courses[dep].inDegree++;
                }
                visited[i] = false;
            }
        }
        return result;
    }
}
