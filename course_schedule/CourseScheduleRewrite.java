import java.util.*;

public class CourseScheduleRewrite {
  public class Node {
    int inDegree;
    List<Integer> dependents;

    Node() {
      this.inDegree = 0;
      this.dependents = new ArrayList<>();
    }

  }
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
      return true;
    }

    Node[] nodes = new Node[numCourses];
    for (int i = 0; i < numCourses; i++) {
      nodes[i] = new Node();
    }
    // Build a graph
    for (int[] course: prerequisites) {
      nodes[course[1]].dependents.add(course[0]);
      nodes[course[0]].inDegree++;
    }

    Queue<Node> queue = new LinkedList<>();
    for (Node node: nodes) {
      if (node != null && node.inDegree == 0) {
        queue.offer(node);
      }
    }

    int index = 0;
    while(queue.size() != 0) {
      Node curr = queue.poll();
      index++;

      for (int dependent: curr.dependents) {
        nodes[dependent].inDegree -= 1;
        if (nodes[dependent].inDegree == 0) {
          queue.add(nodes[dependent]);
        }
      }
    }

    return index == numCourses;
  }
}
