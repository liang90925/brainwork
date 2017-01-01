
// 使用两个dp 数组，一个存递增的状态， 一个存递减的状态

public class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] increase = new int[nums.length];
    int[] decrease = new int[nums.length];
    increase[0] = decrease[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        increase[i] = decrease[i - 1] + 1;
        decrease[i] = decrease[i - 1];
      } else if (nums[i] < nums[i - 1]) {
        decrease[i] = increase[i - 1] + 1;
        increase[i] = increase[i - 1];
      } else {
        decrease[i] = decrease[i - 1];
        increase[i] = increase[i - 1];
      }
    }
    return Math.max(increase[nums.length - 1], decrease[nums.length - 1]);
  }
}
