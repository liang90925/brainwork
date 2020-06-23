public class Backpack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A.length == 0 || m == 0) {
            return 0;
        }
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int num : A) {
            for (int i = m; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}
