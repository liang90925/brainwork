public class Solution {
  public int splitArray(int[] nums, int m) {
    if (nums == null || nums.length == 0 || m <= 0) {
      return 0;
    }
    // find the lagest number in nums and the sum of all numbers in nums
    // when m = 1, max is the sum; when m = nums.length(), max is the largest number
    // therefore when 1 < m < len, the result should be with in large_um ~ sum
    int left = 0;
    int right = 0;
    for (int num : nums) {
      left = Math.max(left, num);
      right += num;
    }
    if (m == 1) {
      return right;
    }
    if (m == nums.length) {
      return left;
    }
    // use binary search to find the result;
    int ans = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      // check if the array can be seperate into m arrays with the max value in one item
      // if yes, that means the mid value can be the ans or larger, so move right to mid - 1;
      // else move left to mid + 1;
      if (check(nums, m, mid)) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }

  private boolean check(int[] nums, int m, int max) {
    int count = 1;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        return false;
      }
      sum += nums[i];
      if (sum > max) {
        sum = num[i];
        count++;
      }
    }
    return count <= m;
  }
}
