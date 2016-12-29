public class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0 || costs[0].length == 0) {
      return 0;
    }

    // manage a 2D dp array, it stores the minCost of paint house i with color j
    // and the result will be the min cost of paint the last house with color r, b, or g
    int houseNum = costs.length;
    int colorNum = costs[0].length;
    int[][] dp = new int[houseNum][colorNum];
    int min1 = -1, min2 = -1;

    for (int i = 0; i < houseNum; i++) {
      // Those two lines of code is important.
      int last1 = min1, last2 = min2;
      min1 = -1; min2 = -1;
      for (int j = 0; j < colorNum; j++) {

        if (i == 0) {
          dp[i][j] = costs[i][j];
        } else {
          int minColorInx = last1 == j ? last2 : last1;
          dp[i][j] = costs[i][j] + dp[i - 1][minColorInx];
        }

        // for the min and secondmin value, need to check if they are -1 first, or dp[i][min1] will throw error
        if (min1 < 0 || dp[i][j] < dp[i][min1]) {
          min2 = min1;
          min1 = j;
        } else if (min2 < 0 || dp[i][j] < dp[i][min2]) {
          min2 = j;
        }
      }
    }
    return dp[houseNum - 1][min1];
  }
}
