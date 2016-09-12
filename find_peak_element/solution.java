public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int nLth = nums.length;
    int start = 0, end = nLth - 1, mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;

      if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
        (mid == nLth - 1 || nums[mid] > nums[mid + 1])) {
        return mid;
      }
      if (mid > 0 && nums[mid] < nums[mid - 1]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return mid;
  }
}
