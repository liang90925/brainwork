public class BTTBASSWITHTF {
  public int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int len = prices.length;

    int buy = -prices[0] - fee;
    int sell = 0;

    for (int i = 1; i < prices.length; i++) {
      sell = Math.max(sell, buy + prices[i]);
      buy = Math.max(buy, sell - prices[i] - fee);
    }
    return sell;
  }
}
