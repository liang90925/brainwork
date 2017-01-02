public class Solution {
  private int row, col;

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
        bfs(visited, i, j);
      }
    }
    return count;
  }

  private void bfs(boolean[][] visited, int x, int y) {
    visited[x][y] = true;
    Queue<Integer> que = new LinkedList<>();
    int code = x * col + y;
    que.offer(code);
    while (!que.isEmpty()) {
      int curr = que.poll();
      int i = curr / col;
      int j = curr % col;
      if (i > 0 && !visited[i - 1][j]) {
        que.offer((i - 1) * col + j);
        visited[i - 1][j] = true;
      }
      if (i < row - 1 && !visited[i + 1][j]) {
        que.offer((i + 1) * col + j);
        visited[i + 1][j] = true;
      }
      if (j > 0 && !visited[i][j - 1]) {
        que.offer((i) * col + j - 1);
        visited[i][j - 1] = true;
      }
      if (j < col - 1 && !visited[i][j + 1]) {
        que.offer((i) * col + j + 1);
        visited[i][j + 1] = true;
      }
    }
  }
}
