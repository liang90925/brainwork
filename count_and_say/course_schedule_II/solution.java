public class Solution {
  class Node {
    Set<Integer> children;
    int inDegree;
    Node() {
      children = new HashSet<>();
      inDegree = 0;
    }
  }
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
      return true;
    }
    Map<Integer, Node> graph = new HashMap<>();

    // build the graph
    for (int[] pair : prerequisites) {
      if (!graph.containsKey(pair[0])) {
        graph.put(pair[0], new Node());
      }

      if (!graph.containsKey(pair[1])) {
        graph.put(pair[1], new Node());
      }

      if (!graph.get(pair[0]).children.contains(pair[1])) {
        graph.get(pair[0]).children.add(pair[1]);
        graph.get(pair[1]).inDegree++;
      }
    }

    // topology sort
    Queue<Integer> que = new LinkedList<>();
    for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
      if (entry.getValue().inDegree == 0) {
        que.offer(entry.getKey());
      }
    }

    int courseNum = 0;
    while (!que.isEmpty()) {
      int curr = que.poll();
      courseNum++;
      for (int childIndex : graph.get(curr).children) {
        graph.get(childIndex).inDegree--;
        if (graph.get(childIndex).inDegree == 0) {
          que.offer(childIndex);
        }
      }
    }

    for (Map.Entry<Integer, Node> entry : graph.entrySet()) {
      if (entry.getValue().inDegree != 0) {
        return false;
      }
    }

    return true;
  }
}
