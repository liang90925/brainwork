// since it's a circle we can view the circle as two non circle path
// and do the houseRobber twice and compare the result;

public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    return Math.max(houseRob(nums, 0, nums.length - 1), houseRob(nums, 1, nums.length));
  }

  private int houseRob(int[] nums, int start, int end) {
    int prev2 = 0;
    int prev1 = nums[start];
    int max = 0;
    for (int i = start + 1; i < end; i++) {
      max = Math.max(prev1, nums[i] + prev2);
      prev2 = prev1;
      prev1 = max;
    }
    return prev1;
  }
}
