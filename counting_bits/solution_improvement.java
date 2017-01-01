public class Solution {
  public int[] countBits(int num) {
    if (num < 0) {
      return new int[0];
    }
    int[] result = new int[num + 1];
    result[0] = 0;

    // 每一个2^n的数的结果都为0 result【0】 + 1
    // 每一个2^n + m的数的结果都为 result【0 + m】 + 1
    // 所以求出每个数的最高位2^n, 然后用 数字 - 2^n 就是m，
    // 然后从已知的数组中找到这个数的结果 + 1
    // 但是其实不需要每次都计算power，因为一个2^n的数字share同一个power
    int powerVal = 1;
    for (int i = 1; i <= num; i++) {
      result[i] = result[i - powerVal] + 1;

      powerVal <<= i == powerVal;

    }
    return result;
  }
}
