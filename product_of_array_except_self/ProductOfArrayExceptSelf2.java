public class ProductOfArrayExceptSelf2 {
  // o(n) time complexity  without using division and with O(1) space.
  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] result = new int[nums.length];
    result[0] = 1;
    // calculate the product of each num's left
    for (int i = 1; i < nums.length; i++) {
      result[i] = result[i - 1] * nums[i - 1];
    }

    int right = 1;
    // calculate the product of each num's right
    for (int i = nums.length - 2; i >= 0; i--) {
      right = right * nums[i + 1];
      result[i] = result[i] * right;
    }
    return result;
  }
}
