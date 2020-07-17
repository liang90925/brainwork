class MaxAreaOfIslandRewrite {
  private static final int[][] RANGE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int r = grid.length;
    int c = grid[0].length;
    int max = 0;
    boolean[][] visited = new boolean[r][c];
    for (int i = 0 ; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == 1) {
          int cnt = dfs(i, j, visited, grid);
          max = Math.max(max, cnt);
        }
      }
    }
    return max;
  }

  private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
    visited[i][j] = true;
    int cnt = 1;
    for (int[] range: RANGE) {
      int x = i + range[0];
      int y = j + range[1];
      if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1 && !visited[x][y]) {
        cnt += dfs(x, y, visited, grid);
      }
    }
    return cnt;
  }
}