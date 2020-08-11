import java.util.*;

public class CourseScheduleIIRewriteAgain {
    public class Node {
        int id;
        int inDegree;
        List<Node> children;

        public Node(int id) {
            this.id = id;
            this.inDegree = 0;
            this.children = new ArrayList<>();
        }
    }


    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }

        Node[] courses = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Node(i);
        }

        for (int[] pair: prerequisites) {
            int child = pair[0];
            int parent = pair[1];
            courses[child].inDegree++;
            courses[parent].children.add(courses[child]);

        }

        Queue<Node> que = new LinkedList<>();
        for (Node node: courses) {
            if (node.inDegree == 0) {
                que.add(node);
            }
        }

        int[] results = new int[numCourses];
        int i = 0;
        while(!que.isEmpty()) {
            Node curr = que.poll();
            results[i++] = curr.id;

            for (Node node: curr.children) {
                node.inDegree--;
                if (node.inDegree == 0) {
                    que.add(node);
                }
            }
        }

        if (i != numCourses) {
            return new int[0];
        } else {
            return results;
        }
    }

    public static void main(String[] args) {
        CourseScheduleIIRewrite solution = new CourseScheduleIIRewrite();
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})) +  " Output: [0,1,2,3] or [0,2,1,3] ");
        System.out.println(Arrays.toString(solution.findOrder(1, new int[][]{})) +  " Output: [0] ");
    }
}
