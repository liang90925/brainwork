public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1][len2];
        int max = 0;
        for (int i = 0; i < len1; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < len2; i++) {
            dp[0][i] = A[0] == B[i] ? 1 : 0;
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j <len2; j++) {
                dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
