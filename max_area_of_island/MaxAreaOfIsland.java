class MaxAreaOfIsland {
  public int maxAreaOfIsland(int[][] grid) {

    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, visit(i, j, grid));
        }
      }
    }
    return max;
  }

  public int visit(int row, int col, int[][] grid) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
      return 0;
    }
    // mark current itemas visited;
    grid[row][col] = 0;

    return 1
            + visit(row - 1, col, grid) // up
            + visit(row + 1, col, grid) // down
            + visit(row, col - 1, grid) // left
            + visit(row, col + 1, grid); // right
  }
//     public int visit(int row, int col, int[][] grid) {
//         // mark as visited;
//         grid[row][col] = 0;

//         int up = 0;
//         int down = 0;
//         int left = 0;
//         int right = 0;

//         // go up row -1
//         if ((row - 1) >= 0 && grid[row-1][col] == 1) {
//             up = visit(row - 1, col, grid);
//         }
//         // go down row + 1
//         if ((row + 1) < grid.length && grid[row+1][col] == 1) {
//             down = visit(row + 1, col, grid);
//         }
//         // go left col -1
//         if ((col - 1) >= 0 && grid[row][col - 1] == 1) {
//             left = visit(row, col - 1, grid);
//         }
//         // go right col + 1
//         if ((col + 1) < grid[0].length && grid[row][col + 1] == 1) {
//             right = visit(row, col + 1, grid);
//         }

//         return 1 + up + down + left + right;
//     }
}