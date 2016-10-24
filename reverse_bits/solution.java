public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;
    int[] bits =  new int[32];
    for (int i = 0; i < 32; i++) {
      bits[i] = n >> i & 1;
      result |= bits[i] << 31 - i;
    }
    return result;
  }
}


public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int result = 0;

    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) {
        result =  (result << 1) + 1;
      } else {
        result = (result << 1);
      }
      n = (n >> 1);
    }
    return result;
  }
}
