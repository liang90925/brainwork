// consider the situation of negative and zero value

public class Solution {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
      return null;
    }

    boolean positive = true;
    if (num1.charAt(0) == '-') {
      num1 = num1.substring(1);
      positive = !positive;
    }
    if (num2.charAt(0) == '-') {
      num2 = num2.substring(1);
      positive = !positive;
    }

    int len1 = num1.length();
    int len2 = num2.length();
    int totalLen = len1 + len2;
    int[] num3 = new int[totalLen];

    for (int i = len1 - 1; i >= 0; i--) {
      int j;
      int carry = 0;
      int product = 0;
      for (j = len2 - 1; j >= 0; j--) {
        product = carry + num3[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        carry = product / 10;
        num3[i + j + 1] = product % 10;
      }
      num3[i + j + 1] = carry;
    }

    StringBuilder sb = new StringBuilder();
    int i = 0;

    // get the first non 0 num
    while (i < totalLen - 1 && num3[i] == 0) {
      i++;
    }
    // build the number
    while (i < totalLen) {
      sb.append(num3[i++]);
    }
    // consider the situation of negative and zero.
    return (sb.toString().equals("0") || positive) ? sb.toString() : ("-" + sb.toString());
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.multiply("0", "456"));
    System.out.println(s.multiply("0", "-456"));
    System.out.println(s.multiply("123", "70"));
    System.out.println(s.multiply("-123", "70"));
    System.out.println(s.multiply("123", "-70"));
    System.out.println(s.multiply("-123", "-70"));
    System.out.println(s.multiply("123", "070"));
  }
}
