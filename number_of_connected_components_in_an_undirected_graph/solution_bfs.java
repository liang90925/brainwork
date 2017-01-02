// 建立邻接表 和一个visit 数组 还有一个queue 然后 bfs求解
// 建立邻接表 和一个visit 数组 然后 dfs求解，


public class Solution {
  public int countComponents(int n, int[][] edges) {

    if (n <= 0 || edges == null) {
      return 0;
    }
    if (n == 1 && edges.length == 0) {
      return 1;
    }

    boolean[] visited = new boolean[n];
    List<Integer>[] edgeList = new ArrayList[n];
    // build the edgeList with empty ArrayList
    for (int i = 0; i < edgeList.length; i++) {
      edgeList[i] = new ArrayList<>();
    }
    //build the edgeList
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];

      edgeList[from].add(to);
      edgeList[to].add(from);

    }

    int count = 0;
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        count++;
        findConnected(visited, edgeList, queue, i);
      }
    }
    return count;
  }

  private void findConnected(boolean[] visited, List<Integer>[] edgeList, Queue<Integer> queue, int i) {
    fill(visited, queue, i);
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      for (int neighbor : edgeList[curr]) {
        fill(visited, queue, neighbor);
      }
    }
    return;
  }

  private void fill(boolean[] visited, Queue<Integer> queue, int i) {
    if (visited[i]) {
      return;
    }
    visited[i] = true;
    queue.offer(i);
  }
}
