public class StoneGameMemorySearchImproved {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame(int[] A) {
        // write your code here
        // Using DP
        if (A == null || A.length <= 1) {
            return 0;
        }
        int len = A.length;

        // initialize
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        // preparation
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 0; i < len; i++) {
            result[i][i] =  0;
            sum[i + 1] = sum[i] + A[i];
        }

        return memSearch(0, len - 1, result, sum);
    }
    public int memSearch(int start, int end, int[][] results, int[] sum) {
        if (results[start][end] != Integer.MAX_VALUE) {
            return results[start][end];
        }
        int subLevelMin = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            subLevelMin = Math.min(
                    subLevelMin,
                    memSearch(start, k, results, sum)
                    + memSearch(k + 1, end, results, sum)
                    + sum[end + 1] - sum[start]
            );
        }
        results[start][end] = subLevelMin;
        return results[start][end];
    }

    public static void main(String[] args) {
        StoneGameMemorySearchImproved stoneGame = new StoneGameMemorySearchImproved();
        stoneGame.stoneGame(new int[]{1,10,11,12,15,16,19,4,5,9,7});
        System.out.println(stoneGame.stoneGame(new int[]{3, 4, 3}) + " ==== 17");
        System.out.println(stoneGame.stoneGame(new int[]{4, 1, 1, 4}) + " ==== 18");
        System.out.println(stoneGame.stoneGame(new int[]{1,10,11,12,15,16,19,4,5,9,7}) + " ==== 363");

    }
}
