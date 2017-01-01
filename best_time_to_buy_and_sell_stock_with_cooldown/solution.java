public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    // means that at i, the max profit when there is no stock at hand
    int[] sell = new int[prices.length];
    // means that at i, the max profit when there is stock at hand
    int[] buy = new int[prices.length];

    //initial state
    sell[0] = 0;
    buy[0] = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      // i-1时已经sell， 或者i-1时买入股票 然后i时sell;
      sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
      if (i >= 2) {
        // i-1时已经买入，已有股票在手，或者在i-2sell了股票，i-1 时cooldown，at i buy stock
        buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
      } else{
        buy[i] = Math.max(buy[i - 1], -prices[i]);
      }
    }
    return sell[prices.length - 1];
  }
}
