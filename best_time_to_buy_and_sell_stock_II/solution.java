public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      int diff = prices[i] > prices[i - 1];
      if (diff > 0) {
        maxProfit += diff;
      }
    }
    return maxProfit;
  }
}
