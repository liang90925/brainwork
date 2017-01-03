public class Solution {
  private static final int[] X_RANGE = {1, -1, 0, 0};
  private static final int[] Y_RANGE = {0, 0, 1, -1};
  int row;
  int col;
  public List<int[]> pacificAtlantic(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }
    row = matrix.length;
    col = matrix[0].length;

    // create two 2d array to store the can flow value;
    boolean[][] toPacific = new boolean[row][col];
    boolean[][] toAtlantic = new boolean[row][col];
    for (int i = 0; i < col; i++) {
      toPacific[0][i] = true;
      toAtlantic[row - 1][i] = true;
    }
    for (int i = 0; i < row; i++) {
      toPacific[i][0] = true;
      toAtlantic[i][col - 1] = true;
    }

    boolean[][] visited;
    for (int i = 0; i < row; i++) {
      visited = new boolean[row][col];
      dfs(toPacific, visited, matrix, i, 0);
      visited = new boolean[row][col];
      dfs(toAtlantic, visited, matrix, i, col -1);
    }
    for (int i = 0; i < col; i++) {
      visited = new boolean[row][col];
      dfs(toPacific, visited, matrix, 0, i);
      visited = new boolean[row][col];
      dfs(toAtlantic, visited, matrix, row - 1, i);
    }

    List<int[]> points = new ArrayList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (toPacific[i][j] && toAtlantic[i][j]) {
          int[] point = {i, j};
          points.add(point);
        }
      }
    }

    return points;
  }

  private void dfs(boolean[][] canFlow, boolean[][] visited, int[][] matrix, int i, int j) {
    if (visited[i][j]) {
      return;
    }
    canFlow[i][j] = true;
    visited[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int x = i + X_RANGE[k];
      int y = j + Y_RANGE[k];
      if (x < 0 || x >= row||y < 0||y >= col || matrix[i][j] > matrix[x][y]) {
        continue;
      }
      dfs(canFlow, visited, matrix, x, y);
    }
    return;
  }
}
