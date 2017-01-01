public class Solution {
  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount < 0) {
      return -1;
    }
    int coinsCnt = coins.length;
    int[] dp = new int[amount + 1];
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      dp[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        int index = i - coin;
        if (index >= 0 && dp[index] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[index] + 1);
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}
