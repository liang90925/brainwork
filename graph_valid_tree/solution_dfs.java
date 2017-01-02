// DFS solution
// DFS solution

public class Solution {
  public boolean validTree(int n, int[][] edges) {
    if (n <= 0 || edges == null) {
      return false;
    }
    if (n == 1 && edges.length == 0) {
      return true;
    }

    if (n != edges.length + 1) {
      return false;
    }
    boolean[] visited = new boolean[n];

    List<Integer>[] edgeList = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      edgeList[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];
      edgeList[x].add(y);
      edgeList[y].add(x);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(edgeList[i]);
    }

    if (!helper(0, -1, edgeList, visited)) {
      return false;
    }

    for (boolean visit : visited) {
      if (!visit) {
        return false;
      }
    }
    return true;
  }
  // 此处需要引入一个parent节点，
  private boolean helper(int i, int parent, List<Integer>[] edgeList, boolean[] visited) {
    if (visited[i]) {
      return false;
    }
    visited[i] = true;
    for (int neighbor : edgeList[i]) {
      // 当neighbor parent节点 和当前节点的neighbor一致时就不需要dfs下去
      if(neighbor != parent) {
        if (!helper(neighbor, i, edgeList, visited)) {
          return false;
        }
      }
    }
    return true;
  }
}
