public class Solution {
  public int removeElement(int[] nums, int val) {
    if ( nums == null || nums.length < 0) {
      return 0;
    }

    int size = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        continue;
      } else {
        nums[size++] = nums[i];
      }
    }
    return size;
  }
}
