public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int lth = nums.length;
    if (nums == null || lth < 3) { return -1; }

    Arrays.sort(nums);
    int bestSum = nums[0] + nums[1] + nums[2];
    for (int i=0; i < (lth-2); i++) {
      int left = i + 1;
      int right = lth - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(target-bestSum) > Math.abs(target-sum)) {
          bestSum = sum;
        }
        if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return bestSum;
  }
}
