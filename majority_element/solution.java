public class Solution {
  public int majorityElement(int[] nums) {
    int count = 0;
    int target = -1;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0 || nums[i] == target) {
        // every time when count reset to 0. target will be set to the curr num.
        target = nums[i];
        count++;
      } else {
        count--;
      }
    }
    return target;
  }
}
