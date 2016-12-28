public class Solution {
  class Node {
    Set<Integer> children;
    int inDegree;
    Node() {
      children = new HashSet<>();
      inDegree = 0;
    }
  }
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null) {
      return new int[0];
    }

    Map<Integer, Node> graph = new HashMap<>();

    // NOTE AND IMPORTANT !!: first initiate the graph with all number of courses!
    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new Node());
    }

    // build the graph with edges and degrees
    for (int[] pair : prerequisites) {
      if (!graph.get(pair[1]).children.contains(pair[0])) {
        graph.get(pair[1]).children.add(pair[0]);
        graph.get(pair[0]).inDegree++;
      }
    }

    // topology sort
    Queue<Integer> que = new LinkedList<>();
    for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
      if (entry.getValue().inDegree == 0) {
        que.offer(entry.getKey());
      }
    }

    int[] courseSeq = new int[numCourses];
    int index = 0;
    while (!que.isEmpty()) {
      int curr = que.poll();
      courseSeq[index++] = curr;
      for (int childIndex : graph.get(curr).children) {
        graph.get(childIndex).inDegree--;
        if (graph.get(childIndex).inDegree == 0) {
          que.offer(childIndex);
        }
      }
    }
    // check if there is a loop in the graph
    // for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
    //   if (entry.getValue().inDegree != 0) {
    //     return new int[0];
    //   }
    // }

    return index != numCourses ? new int[0] : courseSeq;
  }
}
