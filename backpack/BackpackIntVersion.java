public class BackpackIntVersion {
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
        int[] dp = new int[m + 1];

        for (int num : A) {
            for (int i = m; i >= num; i--) {
                dp[i] = Math.max(dp[i], num + dp[i - num]);
            }
        }
        return dp[m];
    }
}
