// 左右两个指针没错， 但是不是交换两个指针的值如交换0，2
// 而是直接在左右两个指针上赋值，比如当扫到0时，交换当前左指针和i所在的值；i++， left++
// 比如当扫到2时，交换当前右指针和i所在的值；right--;


public class Solution {
  public void sortColors(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }

    int len = nums.length;
    int left = 0;
    int right = len - 1;
    int i = 0;
    while (i <= right) {
      if (nums[i] == 0) {
        swap(nums, i, left);
        i++;
        left++;
        continue;
      }
      if (nums[i] == 2) {
        swap(nums, i, right);
        right--;
        continue;
      }
      // 别忘了这个i++， 给nums[i] == 1 的情况
      i++;
    }
  }
  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
