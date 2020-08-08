public class BTTBASSIII {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int len = prices.length;
    int[] preProfit = new int[len];
    int[] postProfit = new int[len];

    int currMin = prices[0];
    for (int i = 1; i < len; i++) {
      currMin = Math.min(prices[i], currMin);
      preProfit[i] = Math.max(preProfit[i - 1], prices[i] - currMin);
    }

    int currMax = prices[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      currMax = Math.max(prices[i], currMax);
      postProfit[i] = Math.max(postProfit[i + 1], currMax - prices[i]);
    }

    int maxProfit = 0;
    for (int i = 0; i < len; i++) {
      maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
    }

    return maxProfit;
  }
}
