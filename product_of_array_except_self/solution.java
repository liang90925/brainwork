public class Solution {
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] result = new int[nums.length];
    result[0] = 1;
    int left = 1, right = 1;
    // calculate the product of each num's left
    for (int i = 1; i < nums.length; i++) {
      left = left *  nums[i - 1];
      result[i] = left * nums[i - 1];
      System.out.println(result[i]);
    }


    // calculate the product of each num's right
    for (int i = nums.length - 2; i >= 0; i--) {
      right = right * nums[i + 1];
      result[i] = result[i] * right;
      System.out.println("right " + right);
      System.out.println("result " + result[i]);
    }
    return result;
  }
}
