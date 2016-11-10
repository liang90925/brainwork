import java.util.*;

public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    }
    int[] max = new int[2];
    max[0] = nums[0];
    max[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < len; i++) {
      max[i % 2] = Math.max(max[(i - 1) % 2], max[(i - 2) % 2] + nums[i]);
    }

    return max[(len + 1) % 2];
  }
}
