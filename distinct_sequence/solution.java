public class Solution {
  public int numDistinct(String s, String t) {
    if (s == null || t == null) {
      return 0;
    }

    int sLen = s.length();
    int tLen = t.length();

    if (sLen < tLen) {
      return 0;
    }

    int[][] dp = new int[sLen + 1][tLen + 1];
    // dp[0][i] = 0 since any string T with larger than 0 length can not be found in an empty string

    for (int i = 0; i <= sLen; i++) {
      // means empty string T can be found in S and the distinct number of subsequence is 1
      dp[i][0] = 1;
    }

    for (int i = 1; i <= sLen; i++) {
      for (int j = 1; j <= tLen; j++) {
        dp[i][j] = dp[i - 1][j];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] += dp[i -1][j -1];
        }
      }
    }
    return dp[sLen][tLen];
  }
}
