
// 此解法是两个 1d array dp的优化， 把sapce complexity 从O(N) 降为 O(1)
// 使用两个constant value，一个存递增的状态， 一个存递减的状态

public class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int inc = 1, dec = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        inc = dec + 1;
        dec = dec;
      } else if (nums[i] < nums[i - 1]) {
        dec = inc + 1;
        inc = inc;
      }
    }
    return Math.max(inc, dec);
  }
}
