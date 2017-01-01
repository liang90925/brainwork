public class Solution {
  /*
  The case for 3 elements example
  Count[3] = Count[0]*Count[2]  (1 as root)
                + Count[1]*Count[1]  (2 as root)
                + Count[2]*Count[0]  (3 as root)

  Therefore, we can get the equation:
  Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1

  */
  public int numTrees(int n) {
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }

    return dp[n];
  }
}
