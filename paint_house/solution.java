public class Solution {
  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) {
      return 0;
    }

    // manage a 2D dp array, it stores the minCost of paint house i with color j
    // and the result will be the min cost of paint the last house with color r, b, or g
    int houseNum = costs.length;
    int colorNum = costs[0].length;
    int[][] dp = new int[houseNum][colorNum];

    for (int i = 0; i < houseNum; i++) {
      for (int j = 0; j < colorNum; j++) {
        if (i == 0) {
          dp[i][j] = costs[i][j];
        } else {
          dp[i][j] = costs[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
        }
      }
    }
    int result = Math.min(Math.min(dp[houseNum - 1][0], dp[houseNum - 1][1]), dp[houseNum - 1][2]);
    return result;
  }
}
