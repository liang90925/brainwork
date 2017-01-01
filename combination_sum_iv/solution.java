public class Solution {
  public int combinationSum4(int[] nums, int target) {
    if (nums == null || nums.length == 0 || target <= 0) {
      return 0;
    }
    int numsLen = nums.length;
    // comb means at index i, say i = 2; there are comb[2] combinations available to form a 2:
    // the dp works that way: dp[i] = dp[i] + dp[i - num]; for all possible num in nums
    int[] comb = new int[target + 1];
    comb[0] = 1;

    for (int i = 1; i < comb.length; i++) {
      for (int num : nums) {
        if (i >= num) {
          comb[i] += comb[i - num];
        }
      }
    }
    return comb[target];
  }
}
