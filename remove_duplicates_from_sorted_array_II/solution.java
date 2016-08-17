public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length < 0) {
      return 0;
    }
    int size = 0;

    for (int i = 0; i < nums.length;) {
      int currentNum = nums[i];
      int j;
      for (j = i; j < nums.length; j++) {
        if (nums[j] != currentNum) {
          break;
        }
        if ((j - i) < 2) {
         nums[size++] = currentNum;
        }
      }
      i = j;
    }
    return size;
  }
}
