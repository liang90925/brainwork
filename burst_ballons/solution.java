public class Solution {
  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int numsLen = nums.length;
    int newNumsLen = nums.length + 2;
    int[] newNums = new int[newNumsLen];
    for (int i = 1; i <= numsLen; i++) {
      newNums[i] = nums[i - 1];
    }
    newNums[0] = newNums[newNumsLen - 1] = 1;
    int[][] dp = new int[newNumsLen][newNumsLen];

    // dp[l][r] = max(dp[l][r], dp[l][m] + nums[l]*nums[m]*nums[r] + dp[m][r])
    // dp[l][r] means the range between (l,r) and not including the boundary l and r
    // example when we have all ballons inside l and r removed except m, then the coins when we remove m is
    // nums[l]*nums[m]*nums[r]; think this with extreem case as nums[-1] * nums[i] * nums[n];
    // therefore we have the recursive formula at the beginning
    
    // the range k should start from 2 and end at newNumsLen - 1
    for (int k = 2; k < newNumsLen; k++) {
      for (int l = 0; l < newNumsLen - k; l++) {
        int r = l + k;
        for (int m = l + 1; m < r; m++) {
          dp[l][r] = Math.max(dp[l][r], dp[l][m] + newNums[l] * newNums[m] * newNums[r] + dp[m][r]);
        }
      }
    }
    return dp[0][newNumsLen - 1];
  }
}
