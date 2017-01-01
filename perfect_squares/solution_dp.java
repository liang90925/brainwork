// dp version

public class Solution {
  public int numSquares(int n) {
    if (n <= 0) {
      return 0;
    }
    int[] dp = new int[n + 1];
    dp[0] = 1;

    Arrays.fill(dp, Integer.MAX_VALUE);
    // for (int i = 1; i <= n; i++) {
    //   dp[i] = Integer.MAX_VALUE;
    // }
    for (int i = 0; i * i <= n; i++) {
      dp[i * i] = 1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 0; i + j * j <= n; j++) {
        dp [i + j* j] = Math.min(dp[i + j * j], dp[i] + 1);
      }
    }
    return dp[n];
  }
}
