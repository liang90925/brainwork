public class BTTBASSWCRewrite {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int buy = Integer.MIN_VALUE;
    int sell = Integer.MIN_VALUE;
    int coolDown = 0;

    for (int price: prices) {
      int preSell = sell;
      sell = buy + price;
      buy = Math.max(buy, coolDown - price);
      coolDown = Math.max(coolDown, preSell);
    }

    return Math.max(sell, coolDown);
  }
}

// referred to https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/