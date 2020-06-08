import java.util.*;

public class CourseScheduleIIRewrite {
  public class Node {
    int courseId;
    int inDegree;
    List<Integer> dependents;
    Node(int courseId) {
      this.courseId = courseId;
      this.inDegree = 0;
      this.dependents = new ArrayList<>();
    }

  }


  /*
   * @param numCourses: a total of n courses
   * @param prerequisites: a list of prerequisite pairs
   * @return: the course order
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // write your code here
    int len = prerequisites.length;

    Node[] nodes = new Node[numCourses];
    for (int i = 0; i < numCourses; i++) {
      nodes[i] = new Node(i);
    }
    // Build a graph
    for (int[] course: prerequisites) {
      nodes[course[1]].dependents.add(course[0]);
      nodes[course[0]].inDegree++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (Node node: nodes) {
      if (node != null && node.inDegree == 0) {
        queue.offer(node.courseId);
      }
    }

    int[] results = new int[numCourses];
    int index = 0;
    while(queue.size() != 0) {

      Node currNode = nodes[queue.poll()];
      results[index++] = currNode.courseId;
      for (int dependent: currNode.dependents) {
        nodes[dependent].inDegree -= 1;
        if (nodes[dependent].inDegree == 0) {
          queue.add(dependent);
        }
      }
    }
    if (index == numCourses) {
      return results;
    }
    return new int[0];
  }

  public static void main(String[] args) {
    CourseScheduleIIRewrite solution = new CourseScheduleIIRewrite();
    System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})) +  " Output: [0,1,2,3] or [0,2,1,3] ");
    System.out.println(Arrays.toString(solution.findOrder(1, new int[][]{})) +  " Output: [0] ");
  }
}
