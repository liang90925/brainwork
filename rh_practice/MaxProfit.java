import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxProfit {
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
        stocks.sort(Comparator.comparingDouble(a -> - a.futr * 1.0 / a.curr));

        stocks.forEach(s -> System.out.println(s.curr));
        double profit = 0;

        int toSpend = money;
        for (Stock s: stocks) {
            if (toSpend <= 0) {
                break;
            }
            if (s.curr * s.num <= toSpend) {
                profit += s.futr * s.num;
                toSpend -= s.curr * s.num;
            } else {
                double amount = toSpend / 1.0 / s.curr;
                profit += s.futr * amount;
                toSpend = 0;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
//        - P1=15, S1=45, A1=3 (AAPL)
//                - P2=40, S2=50, A2=3 (BYND)
//                - P3=25, S3=35, A3=3 (SNAP)
//                - P4=30, S4=25, A4=4 (TSLA)
        MaxProfit maxProfit = new MaxProfit();
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock(15, 45, 3));  //45,  3 *45 = 135
        stocks.add(new Stock(40, 50, 3));  //       112.5
        stocks.add(new Stock(25, 35, 3));  //75,  105
        stocks.add(new Stock(30, 25, 4));

        System.out.println(maxProfit.maxProfit(stocks, 210));
    }
}
