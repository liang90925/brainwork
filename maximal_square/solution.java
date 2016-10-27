// dp

public class Solution {
  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int max = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];

    // setup first col;
    for (int i = 0; i < row; i++) {
      dp[i][0] = matrix[i][0] - '0';
      max = Math.max(dp[i][0], max);
    }

    // setup first row;
    for (int i = 1; i < col; i++) {
      dp[0][i] = matrix[0][i] - '0';
      max = Math.max(dp[0][i] , max);
    }

    // setup
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        } else {
          dp[i][j] = 0;
        }
        max = Math.max(dp[i][j], max);
      }
    }
    return max * max;
  }
}
