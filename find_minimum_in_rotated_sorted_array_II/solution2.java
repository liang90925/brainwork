// solution2: binary searc
// time complexity O(logn)， space complexity(1)
public class Solution {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    int target = nums[end];

    while (start + 1 < end) {
      int midIndex = (start + end) / 2;
      if (nums[midIndex] == nums[end]) {
        end--;
      } else if (nums[midIndex] > nums[end]) {
        start = midIndex;
      } else {
        end = midIndex;
      }
    }
    if (nums[start] < nums[end]) {
      return nums[start];
    }
    return nums[end];
  }
}
