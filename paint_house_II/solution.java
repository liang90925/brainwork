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
    int[] minColor1 = new int[houseNum];
    int[] minColor2 = new int[houseNum];
    for (int i = 0; i < houseNum; i++) {
      minColor1[i] = Integer.MAX_VALUE;
      minColor2[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < houseNum; i++) {
      for (int j = 0; j < colorNum; j++) {
        if (i == 0) {
          dp[i][j] = costs[i][j];
        } else {
          dp[i][j] = costs[i][j] + (dp[i - 1][j] == minColor1[i - 1] ? minColor2[i - 1] : minColor1[i - 1]);
        }
        if (dp[i][j] < minColor1[i]) {
          minColor2[i] = minColor1[i];
          minColor1[i] = dp[i][j];
        } else if (dp[i][j] < minColor2[i]) {
          minColor2[i] = dp[i][j];
        }
      }
    }

    return minColor1[houseNum - 1];
  }
}
