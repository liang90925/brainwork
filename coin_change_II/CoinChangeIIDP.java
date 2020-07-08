public class CoinChangeIIDP {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin: coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeIIDP solution = new CoinChangeIIDP();
        System.out.println(solution.change(5, new int[]{1, 2, 5}) +  " === 4");
        System.out.println(solution.change(3, new int[]{2}) + " === 0");
        System.out.println(solution.change(10, new int[]{10}) + " === 1");
    }
}
