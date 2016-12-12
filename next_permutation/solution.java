public class Solution {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    int index = -1;
    int numsLen = nums.length;
    // from the end, find the first index where it's value < next value
    for (int i = numsLen - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        index = i;
        break;
      }
    }

    // case: 123
    if (index == -1) {
      // reverse current array and return
      reverse(nums, 0, numsLen - 1);
      return;
    }

    int switchIndex = index + 1;
    // else , from the end, find the first index that it's value > the value at index
    for (int i = numsLen - 1; i > index; i--) {
      if (nums[i] > nums[index]) {
        switchIndex = i;
        break;
      }
    }

    // swap the value of switchIndex and index;
    swap(nums, index, switchIndex);

    // swap the rest string after the index;
    reverse(nums, index + 1, numsLen - 1);
  }

  private void reverse(int[] nums, int beg, int end) {
    for (int i = beg, j = end; i < j; i++, j--) {
      swap(nums, i, j);
    }
  }

  private void swap(int[] nums, int p1, int p2) {
    int temp = nums[p1];
    nums[p1] = nums[p2];
    nums[p2] = temp;
  }
}
