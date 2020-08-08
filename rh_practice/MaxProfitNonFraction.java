import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxProfitNonFraction {
    public static class Stock {
        int curr;
        int futr;
        int num;

        public Stock(int curr, int futr, int num) {
            this.curr = curr;
            this.futr = futr;
            this.num = num;
        }
    }

    public double maxProfit(List<Stock> stocks, int money) {
        int[] profit = new int[money + 1];

        for (Stock stock : stocks) {
            int weight = stock.futr;
            int value = stock.curr;
            for (int j = 0; j < stock.num; j++) {
                for (int k = money; k >= value; k--) {
                    profit[k] = Math.max(profit[k], weight + profit[k - value]);
                }
            }
        }
        return profit[money];
    }

    public static void main(String[] args) {
//        - P1=15, S1=45, A1=3 (AAPL)
//                - P2=40, S2=50, A2=3 (BYND)
//                - P3=25, S3=35, A3=3 (SNAP)
//                - P4=30, S4=25, A4=4 (TSLA)
        MaxProfitNonFraction maxProfit = new MaxProfitNonFraction();
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(15, 45, 3));  //45,  3 *45 = 135
        stocks.add(new Stock(40, 50, 3));  //       112.5  100
        stocks.add(new Stock(25, 35, 3));  //75,  105
        stocks.add(new Stock(30, 25, 4));

        System.out.println(maxProfit.maxProfit(stocks, 230));
    }
}
