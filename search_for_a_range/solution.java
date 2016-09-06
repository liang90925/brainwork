public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[]{-1, -1};
    if (nums == null || nums.length == 0) {
      return result;
    }
    // search for left bound
    int start = 0, end = nums.length - 1;

    while (start + 1 < end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        end = mid;
      } else if (nums[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (nums[start] == target) {
      result[0] = start;
    } else if (nums[end] == target) {
      result[0] = end;
    } else {
      return result;
    }

    // search for right bound
    start = 0;
    end = nums.length - 1;

    while (start + 1 < end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        start = mid;
      } else if (nums[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (nums[end] == target) {
      result[1] = end;
    } else if (nums[start] == target) {
      result[1] = start;
    } else {
      return result;
    }
    return result;
  }
}
