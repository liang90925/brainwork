public class MaximumLengthOfRepeatedSubarrayWrong {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            if (i == 0) {
                dp[i][0] = A[i] == B[0] ? 1 : 0;
            } else {
                dp[i][0] = A[i] == B[0] ? 1 : dp[i - 1][0];
            }
        }
        for (int i = 0; i < len2; i++) {
            if (i == 0) {
                dp[0][i] = A[0] == B[i] ? 1 : 0;
            } else {
                dp[0][i] = A[0] == B[i] ? 1 : dp[0][i - 1];
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j <len2; j++) {
                int cand1 = dp[i - 1][j - 1] + (A[i] == B[j] ? 1 : 0);
                int cand2 = dp[i - 1][j];
                int cand3 = dp[i][j - 1];

                dp[i][j] = Math.max(cand1, Math.max(cand2, cand3));
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
