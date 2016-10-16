public class Solution {
  public int minDistance(String word1, String word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    int row = word1.length();
    int col = word2.length();

    int[][] dp = new int[row + 1][col + 1];

    // build row:0 and col:0
    for (int i = 0; i <= col; i++) {
      dp[0][i] = i;
    }
    for (int i = 0; i <= row; i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
      }
    }
    return dp[row][col];
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String word1 = "abcd";
    String word2 = "aca";
    System.out.println(solution.minDistance(word1, word2));
  }
}
