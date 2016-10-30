// divide and conquer
// O(Nlog(N))
// divide to left and right
// the max is between, left , right and cross, note how to cal the cross!
// Note the function getCrossMax

public class Solution {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return divideAndConqure(nums, 0, nums.length - 1);
  }

  private int divideAndConqure(int[] nums, int start, int end) {
    if (start == end) {
      return nums[start];
    }
    int mid = start + (end - start) / 2;
    int left = divideAndConqure(nums, start, mid);
    int right = divideAndConqure(nums, mid + 1, end);
    int cross = getCrossMax(nums, start, mid, end);

    return Math.max(Math.max(left, right), cross);
  }

  private int getCrossMax(int[] nums, int start, int mid, int end) {
    int leftMax = Integer.MIN_VALUE, leftSum = 0;
    int rightMax = Integer.MIN_VALUE, rightSum = 0;
    for (int i = mid; i >= start; i--) {
      leftSum += nums[i];
      leftMax = Math.max(leftMax, leftSum);
    }
    for (int i = mid + 1; i <= end; i++) {
      rightSum += nums[i];
      rightMax = Math.max(rightMax, rightSum);
    }
    return Math.max(Math.max(leftMax, rightMax), (leftMax + rightMax));
  }
}
