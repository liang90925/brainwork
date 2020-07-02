import java.util.Set;
// using dynamic programming;
// dp has size = s.size() + 1;
// dp[0] = true;
// dp[i + 1] = true if there exists a 0 <= k <= i
//              that make dp[k] = true and s.substring(k, i + 1) in dict.
// NOTE: s.substring(k, i + 1) 是指begin index and end index.

public class WordBreakRewrite {
  public boolean wordBreak(String s, Set<String> wordDict) {
    if (s == null || s.length() == 0 || wordDict.size() == 0) {
      return false;
    }
    int sLen = s.length();
    boolean[] dp = new boolean[sLen + 1];
    dp[0] = true;

    for (int i = 1; i <= sLen; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
        }
      }
    }
    return dp[sLen];
  }
}
