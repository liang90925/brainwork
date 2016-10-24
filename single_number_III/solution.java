public class Solution {
  public int[] singleNumber(int[] nums) {
    int[] result = new int[2];
    if (nums == null || nums.length == 0) {
      return result;
    }
    int xor = 0;
    for (int i = 0; i < nums.length; i++) {
      xor ^= nums[i];
    }

    int lastBitOne = xor - (xor & (xor -1));
    int singleNum1 = 0;
    int singleNum2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((lastBitOne & nums[i]) == 0) {
        singleNum1 ^= nums[i];
      } else {
        singleNum2 ^= nums[i];
      }
    }
    result[0] = singleNum1;
    result[1] = singleNum2;
    return result;
  }
}
