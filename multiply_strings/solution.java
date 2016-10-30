public class Solution {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
      return null;
    }

    char[] num1Ch = num1.toCharArray();
    char[] num2Ch = num2.toCharArray();

    int num1Len = num1.length();
    int num2Len = num2.length();
    int totlLen = num1Len + num2Len;
    int[] num3 = new int[totlLen];

    //start from the end of the two num arrays
    for (int i = num1Len - 1; i >= 0; i--) {
      int carry = 0;
      int product = 0;
      int j;
      for (j = num2Len - 1; j >= 0; j--) {
        // !!NOTE!!!!! How to construct the product;
        // Remember to add the num3[i + j + 1] to it, num3[i + j + 1] can be generated from previous production
        product = carry + num3[i + j + 1] + (num1Ch[i] - '0') * (num2Ch[j] - '0');
        carry = product / 10;
        num3[i + j + 1] = product % 10;
      }
      // !!NOTE!!!!!!! Don't forget to assign carry to num3[i + j + 1]
      num3[i + j + 1] = carry;
    }

    StringBuilder sb = new StringBuilder();
    int i = 0;
    // from i = 0, find the first number in num3 that is not 0
    while (i < totlLen - 1 && num3[i] == 0) {
      i++;
    }
    while (i < totlLen) {
      sb.append(num3[i++]);
    }
    return sb.toString();
  }
}
