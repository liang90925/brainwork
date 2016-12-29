public class Solution {

  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] minLast = new int[nums.length + 1];
    minLast[0] = Integer.MIN_VALUE;
    for (int i = 1; i <= nums.length;i ++) {
      minLast[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < nums.length; i++) {
      int index = binarySearch(nums[i], minLast);
      minLast[index] = nums[i];
    }

    for (int i = nums.length; i >=1; i--) {
      if (minLast[i] != Integer.MAX_VALUE) {
        return i;
      }
    }
    return 0;
  }

  // find the first index > num
  private int binarySearch(int num, int[] minLast) {
    int start = 0, end = minLast.length - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2 + start;
      if (minLast[mid] < num) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (minLast[start] > num) {
      return start;
    }
    return end;
  }
}
