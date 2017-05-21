/**
 * Created by liangjin on 5/19/17.
 */
public class LongestPalindromeSubsequence {
  public int longestPalindromeSubseq(String str) {
    if (str == null) {
      return 0;
    }
    int len = str.length();
    // dynamic programming
    /*
      dp[i][j] means the longest palindrome subseq from index i to index j
      dp[i][j] = dp[i + 1][j - 1] + 2  (if str[i] == str[j])
      else
      dp[i][j] = max of ( dp[i + 1][j] , dp[i][j - 1] )
     */
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
