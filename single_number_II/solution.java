public class Solution {
  public int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int result = 0;
    // new a 32 int array
    int[] bits = new int[32];

    // store the addition of bits of each num and mod by 3 to bits,
    for (int i = 0; i < 32; i++) {
      for (int j = 0; j < nums.length; j++) {
        bits[i] += nums[j] >> i & 1;
        bits[i] %= 3;
      }
      // each bit need to move to left and | with result;
      result |= (bits[i] << i);
    }
    return result;
  }
}
