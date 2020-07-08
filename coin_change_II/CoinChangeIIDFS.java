import java.util.HashMap;
import java.util.Map;

public class CoinChangeIIDFS {
    public int change(int amount, int[] coins) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(memo, amount, coins, 0);
    }

    private int dfs(Map<Integer, Integer> memo, int amount, int[] coins, int idx) {

        if (amount == 0) {
            return 1;
        } else if (idx >= coins.length) {
            return 0;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int numCoins = 1;
        int cnt = 0;
        while(numCoins * coins[idx] <= amount) {
            cnt += dfs(memo, amount - coins[idx], coins, idx + 1);
            numCoins++;
        }
        memo.put(amount, cnt);
        return memo.get(amount);
    }
    public static void main(String[] args) {
        CoinChangeIIDFS solution = new CoinChangeIIDFS();
        System.out.println(solution.change(5, new int[]{1, 2, 5}) +  " === 4");
        System.out.println(solution.change(3, new int[]{2}) + " === 0");
        System.out.println(solution.change(10, new int[]{10}) + " === 1");
    }
}
