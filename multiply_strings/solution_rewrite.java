public class Solution {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
      return null;
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
    while (i < totalLen) {
      sb.append(num3[i++]);
    }
    return sb.toString();
  }
}
