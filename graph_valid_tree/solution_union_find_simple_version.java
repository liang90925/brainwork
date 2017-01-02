// union find solution

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

    int[] root = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
    }

    for (int i = 0; i < edges.length; i++) {
      int x = find(root, edges[i][0]);
      int y = find(root, edges[i][1]);
      if (x == y) {
        return false;
      }
      root[x] = y;
    }
    return true;
  }

  private int find(int[] root, int i) {
    while (i != root[i]) {
      root[i] = root[root[i]];
      i = root[i];
    }
    return i;
  }
}
