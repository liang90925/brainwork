// methods 1
// the maxsum at i is Max of (itself and itself+maxsum[i - 1])
// need another variable to record the
// time complexity:  O(n)
// space complexity: O(n)


public class maximumSubArrayDP1 {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int len = nums.length;
    int[] maxSum = new int[len];

    maxSum[0] = nums[0];
    int max = maxSum[0];

    for (int i = 1; i < len; i++) {
      maxSum[i] = Math.max(nums[i], maxSum[i - 1] + nums[i]);
      max = Math.max(max, maxSum[i]);
    }

    return max;
  }
}
