public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int prev2 = 0;
    int prev1 = nums[0];
    int max = 0;
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(prev1, prev2 + nums[i]);
      prev2 = prev1;
      prev1 = max;
    }
    return prev1;
  }
}
