import java.util.*;

public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    if (nums == null || nums.length <= 2) {
      return 0;
    }
    Arrays.sort(nums);
    // 因为找最小的所以应该是iterate最小的那个数，然后剩下的两个用双指针法，
    // 开始时，左指针为最小的数的右边一个，右指针为最右的数， 然后while loop他们看大小和targe差然后挪动两个指针
    int result = 0;
    int numLen = nums.length;
    for (int i = 0; i < numLen - 2; i++) {
      int left = i + 1, right = numLen - 1;

      while (left < right) {
        // 此处要注意，因为我们选择的是左边最小的值和右边最大的，当此情况满足条件时，中间所有的数都会满足条件
        // 所以result += (right - left); 此时就应该让left++，看下一个跟小的区间里更大的值能不能满足情况
        // 如果此时不满足说明数字太大，所有需要减小right处的数值
        if (nums[i] + nums[left] + nums[right] < target) {
          result += (right - left);
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution sl = new Solution();
    int[] nums = {0, -2, 3, 1};
  }
}
