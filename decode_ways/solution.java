import java.util.*;


// using dynamic programming
// 非常容易错，因为corner case比较多， 此solution比较  巧妙地考虑周全了md
public class Solution {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int size = s.length();
    int[] dp = new int[size + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i <= size; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] = dp[i - 1];
      }
      int val = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
      if (val >= 10 && val <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[size];
  }
}
