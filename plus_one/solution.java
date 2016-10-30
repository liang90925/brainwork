// maintain a carrier to keep track if we need to add it to next digit
// if not, then the digits is good and can be returned
// if until the start of the digits, we sill have carrier, that means
// for the result, we need to add a 1 before the new digits get;

public class Solution {
  public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) {
      return digits;
    }
    int len = digits.length;
    int carry = 1;
    for (int i = len - 1; i >= 0; i--) {
      int addition = digits[i] + carry;
      digits[i] = addition % 10;
      carry = addition / 10;
      if (carry == 0) {
        return digits;
      }
    }
    int[] result = new int[len + 1];
    result[0] = carry;
    for (int i = 1; i < len + 1; i++) {
      result[i] = digits[i - 1];
    }
    return result;
  }
}
