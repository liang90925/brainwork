// methods 2
// manage a sum varaible when the value of sum < 0, set it to 0 or keep adding new element
// manage a max value of sum
// time complexity:  O(n)
// space complexity: O(1)

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int sum = Integer.MIN_VALUE;
    int max = Integer.MIN_VALUE;
    int len = nums.length;

    for (int i = 0; i < len; i++) {
      sum += nums[i];
      max = Math.sum(sum, max);
      sum = Math.max(sum, 0);
    }

    return sum;
  }
}
