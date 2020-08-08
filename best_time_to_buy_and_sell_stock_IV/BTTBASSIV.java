//2D array

public class BTTBASSIV {
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length < 0 || k <= 0) {
      return 0;
    }
    int days = prices.length;

    if (k >= days) {
      return maxProfit2(prices);
    }
    // local[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
    int[][] local = new int[days][k + 1];
    // global[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益
    int[][] global = new int[days][k + 1];

    for (int i = 1; i < days; i++) {
      int diff = prices[i] - prices[i - 1];
      for (int j = 1; j <= k; j++) {
        local[i][j] = Math.max(local[i - 1][j] + diff, global[i - 1][j - 1] + diff);
        global[i][j] = Math.max(global[i - 1][j], local[i][j]);
      }
    }
    return global[days - 1][k];
  }

  private int maxProfit2(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += (prices[i] - prices[i - 1]);
      }
    }
    return maxProfit;
  }
}
