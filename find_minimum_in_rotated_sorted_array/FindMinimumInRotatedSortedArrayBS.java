// solution2: binary searc
// time complexity O(logn)， space complexity(1)
public class FindMinimumInRotatedSortedArrayBS {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    int target = nums[end];

    while (start < end - 1) {
      int midIndex = (start + end) / 2;
      if (nums[midIndex] > target) {
        start = midIndex;
      } else {
        end = midIndex;
      }
    }
    return Math.min(nums[start], nums[end]);
  }
}
