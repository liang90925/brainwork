public class SolutionDFS {

  private int row, col;
  private void dfs(boolean[][] visited, int x, int y) {
    if (x < 0 || x >= row || y < 0 || y >= col) {
      return;
    }
    //if (grid[x][y] == '1' && !visited[x][y]) {
    if (!visited[x][y]) {
      visited[x][y] = true;
      dfs(visited, x - 1, y);
      dfs(visited, x + 1, y);
      dfs(visited, x, y - 1);
      dfs(visited, x, y + 1);
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    row = grid.length;
    col = grid[0].length;
    boolean[][] visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        visited[i][j] = grid[i][j] == '0' ? true : false;
      }
    }
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (visited[i][j]) {
          continue;
        }
        count++;
        dfs(visited, i, j);
      }
    }
    return count;
  }
}
