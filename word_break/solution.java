import java.util.*;
// using dynamic programming;
// dp has size = s.size() + 1;
// dp[0] = true;
// dp[i + 1] = true if there exists a 0 <= k <= i
//              that make dp[k] = true and s.substring(k, i + 1) in dict.
// NOTE: s.substring(k, i + 1) 是指begin index and end index.

public class Solution {
  public boolean wordBreak(String s, Set<String> wordDict) {
    if (s == null || s.length() == 0 || wordDict == null) {
      return false;
    }
    int size = s.length();

    boolean[] dp = new boolean[size + 1];
    dp[0] = true;

    for (int i = 0; i < size; i++) {
      for (int j = i; j >= 0; j--) {
        if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
          dp[i + 1] = true;
          break;
        }
      }
    }
    return dp[size];
  }
}
