public class Solution {
  private static final int[] X_RANGE = {1, -1, 0, 0};
  private static final int[] Y_RANGE = {0, 0, 1, -1};
  int row;
  int col;
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    row = rooms.length;
    col = rooms[0].length;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (rooms[i][j] == 0) {
          dfs(rooms, i, j, 0);
        }
      }
    }
  }

  private void dfs(int[][] rooms, int i, int j, int level) {
    if (i < 0 || j < 0 || i >= row || j >= col || rooms[i][j] < level) {
      return;
    }
    rooms[i][j] = level;
    for (int k = 0; k < 4; k++) {
      int x = i + X_RANGE[k];
      int y = j + Y_RANGE[k];
      dfs(rooms, x, y, level + 1);
    }
  }
  // NOTE~!!!!! both the above and below code can pass the test, just different version of dfs;

  // private void dfs(int[][] rooms, int i, int j, int level) {
  //   for (int k = 0; k < 4; k++) {
  //     int x = i + X_RANGE[k];
  //     int y = j + Y_RANGE[k];
  //     if (x < 0 || y < 0 || x >= row || y >= col || rooms[x][y] <= level) {
  //       continue;
  //     }
  //     rooms[x][y] = level + 1;
  //     dfs(rooms, x, y, level + 1);
  //   }
  // }
}
