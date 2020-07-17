public class SolutionUnionFind {

  public class UnionFind {
    private int[] root;
    private int count;

    public UnionFind(int n) {
      this.root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
    }

    public void setTotal(int total) {
      this.count = total;

    }

    public void connect(int m, int n) {
      int x = find(m);
      int y = find(n);
      if (x != y) {
        count--;
        root[x] = y;
      }
    }

    private int find(int i) {
      while (root[i] != i) {
        root[i] = root[root[i]];
        i = root[i];
      }
      return i;
    }

    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int row = grid.length;
    int col = grid[0].length;
    boolean[][] visited = new boolean[row][col];

    UnionFind uf = new UnionFind(row * col);
    //build total and setup visited
    int total = 0;
    for(int i = 0; i < row; i++) {
      for(int j = 0;j < col; j++) {
        if (grid[i][j] == '1') {
          total++;
        } else {
          visited[i][j] = true;
        }
      }
    }
    uf.setTotal(total);

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (!visited[i][j]) {
          if (i > 0 && !visited[i - 1][j]) {
            uf.connect(i * col  + j, (i - 1) * col + j);
          }
          if (i < row - 1 && !visited[i + 1][j]) {
            uf.connect(i * col  + j, (i + 1) * col + j);
          }
          if (j > 0 && !visited[i][j - 1]) {
            uf.connect(i * col  + j, i * col + j - 1);
          }
          if (j < col - 1 && !visited[i][j + 1]) {
            uf.connect(i * col  + j, i * col + j + 1);
          }
        }
      }
    }
    return uf.getCount();
  }
}
