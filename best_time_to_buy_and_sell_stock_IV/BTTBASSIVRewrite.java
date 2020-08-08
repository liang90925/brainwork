import java.util.Arrays;

// This is a much easier version, easier to understand and only need constant space
// Referred to https://www.youtube.com/watch?v=ZRK5t8svQ9o
public class BTTBASSIVRewrite {
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length <= 0 || k <= 0) {
      return 0;
    }
    int len = prices.length;
    if (k >= len/2) {
      return multiTransaction(prices);
    }

    int[] buy = new int[k];
    int[] sell = new int[k];

    Arrays.fill(buy, Integer.MIN_VALUE);
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < k; j++) {
        buy[j] = Math.max(buy[j], j == 0 ? 0 - prices[i] : sell[j - 1] - prices[i]);
        sell[j] = Math.max(sell[j], buy[j] + prices[i]);
      }
    }
    return sell[k - 1];
  }

  private int multiTransaction(int[] prices) {
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxProfit += (prices[i] - prices[i - 1]);
      }
    }
    return maxProfit;
  }
}
