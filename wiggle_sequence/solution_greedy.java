
// greed algorithm

public class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if(nums.length <= 1) {
      return nums.length;
    }

    int flag = 0, len = nums.length, ans = len;

    for (int i = 1; i < len; i++) {
      if (nums[i] == nums[i - 1]) {
        ans--;
      } else if (nums[i] > nums[i - 1]) {
        if (flag == 1) {
          ans--;
        } else {
          flag = 1;
        }
      } else if (nums[i] < nums[i - 1]) {
        if (flag == -1) {
          ans--;
        } else {
          flag = -1;
        }
      }
    }
    return ans;
  }
}
