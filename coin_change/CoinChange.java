import java.util.Arrays;

public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount < 0) {
      return -1;
    }

    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;

    for (int coin: coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
      }
    }
    return dp[amount] >= max ? -1 : dp[amount];
  }
}
