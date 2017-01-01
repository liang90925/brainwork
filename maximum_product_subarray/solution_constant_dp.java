public class Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = nums[0];
    int min = nums[0];
    int maxProd = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int timesMax = nums[i] * max;
      int timesMin = nums[i] * min;
      max = Math.max(Math.max(timesMax, timesMin), nums[i]);
      min = Math.min(Math.min(timesMax, timesMin), nums[i]);
      maxProd = Math.max(maxProd, max);
    }
    return maxProd;
  }
}
