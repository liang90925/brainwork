public class StoneGameDP {
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
        // what is the difference of f and sum
        int[][] f = new int[len][len];
        boolean[][] visited = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            f[i][i] = 0;
        }

        // preparation
        int[][] sum = new int[len][len];
        for (int i = 0; i < len; i++) {
            sum[i][i] =  A[i];
            for (int j = i + 1; j < len; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        return memSearch(0, len - 1, f, visited, sum);
    }

    public int memSearch(int start, int end, int[][] f, boolean[][] visited, int[][] sum) {
        if (visited[start][end]) {
            return f[start][end];
        }
        if (start == end) {
            visited[start][end] = true;
            return f[start][end];
        }
        f[start][end] = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            f[start][end] =  Math.min(
                    f[start][end],
                    memSearch(start, k, f, visited, sum)
                    + memSearch(k + 1, end, f, visited, sum)
                    + sum[start][end]
            );
        }
        visited[start][end] = true;
        return f[start][end];
    }


    public static void main(String[] args) {
        StoneGameDP stoneGame = new StoneGameDP();
        stoneGame.stoneGame(new int[]{1,10,11,12,15,16,19,4,5,9,7});
        System.out.println(stoneGame.stoneGame(new int[]{3, 4, 3}) + " ==== 17");
        System.out.println(stoneGame.stoneGame(new int[]{4, 1, 1, 4}) + " ==== 18");
        System.out.println(stoneGame.stoneGame(new int[]{1,10,11,12,15,16,19,4,5,9,7}) + " ==== 363");

    }
}
