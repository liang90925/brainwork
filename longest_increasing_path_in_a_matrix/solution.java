public class Solution {
  private final static int[] xMove = {-1, 1, 0, 0};
  private final static int[] yMove = {0, 0, -1, 1};
  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int maxPath = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        maxPath = Math.max(maxPath, helper(matrix, i, j, dp));
      }
    }

    return maxPath;
  }

  private int helper(int[][] matrix, int row, int col, int[][] dp) {
    if (dp[row][col] > 0) {
      return dp[row][col];
    }
    int currMax = 0;
    for (int i = 0; i < xMove.length; i++) {
      int x = row + xMove[i];
      int y = col + yMove[i];

      if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
          matrix[x][y] > matrix[row][col]) {

        currMax = Math.max(currMax, helper(matrix, x, y, dp));
      }
    }
    dp[row][col] = currMax + 1;
    return currMax + 1;
  }
}
