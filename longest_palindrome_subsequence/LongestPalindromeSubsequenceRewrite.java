/**
 * Created by liangjin on 5/19/17.
 */
// Remember the loop has to go from bottom to top and from left to right

public class LongestPalindromeSubsequenceRewrite {
  public int longestPalindromeSubseq(String str) {
    if (str == null) {
      return 0;
    }
    int len = str.length();
    int[][] dp = new int[len][len];
    for (int i = len - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i + 1; j < len; j++) {
        if (str.charAt(i) == str.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][len - 1];
  }

}
