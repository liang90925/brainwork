public class Solution {
  public String addStrings(String num1, String num2) {
    int len1 = num1.length() - 1;
    int len2 = num2.length() - 1;

    StringBuilder sb = new StringBuilder();

    int sum = 0, carry = 0;

    while (len1 >= 0 || len2 >=0) {
      int first = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
      int second = len2 >= 0 ? num2.charAt(len2) - '0' : 0;

      sum = carry + first + second;

      sb.insert(0, sum % 10);

      carry = sum / 10;
      len1--;
      len2--;
    }
    if (carry > 0) {
      sb.insert(0, carry);
    }
    return sb.toString();
  }
}
