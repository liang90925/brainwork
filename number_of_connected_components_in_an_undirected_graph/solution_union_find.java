// 并查集， union find 解法
// create 一个 root array， 更新root array的数据

public class Solution {
  public int countComponents(int n, int[][] edges) {
    if (n <= 0 || edges == null) {
      return 0;
    }
    if (n == 1 && edges.length == 0) {
      return 1;
    }

    int[] root = new int[n];
    int count = n;

    // initiate the root array with the i
    for (int i = 0; i < n; i++) {
      root[i] = i;
    }

    for (int[] edge : edges) {
      int x = getRoot(root, edge[0]);
      int y = getRoot(root, edge[1]);
      if (x != y) {
        count--;
        root[x] = y;
      }
    }
    return count;
  }
  private int getRoot(int[] root, int i) {
    while (root[i] != i) {
      root[i] = root[root[i]];
      i = root[i];
    }
    return i;
  }
}
