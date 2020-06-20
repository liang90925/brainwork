import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// using dynamic programming;
// dp has size = s.size() + 1;
// dp[0] = true;
// dp[i + 1] = true if there exists a 0 <= k <= i
//              that make dp[k] = true and s.substring(k, i + 1) in dict.
// NOTE: s.substring(k, i + 1) 是指begin index and end index.

public class WordBreakDfs {
  public boolean wordBreak(String s, Set<String> wordDict) {
    Map<String, Boolean> wordMem = new HashMap<>();
    return dfs(0, s, wordDict, wordMem);
  }

  private boolean dfs(int now, String s, Set<String> wordDict, Map<String, Boolean> wordMem) {
    if (now == s.length()) {
      return true;
    }
    if (wordMem.containsKey(s.substring(now))) {
      return wordMem.get(s.substring(now));
    }

    for (int i = 1; i + now <= s.length(); i++) {
      if (wordDict.contains(s.substring(now, now + i)) && dfs(now + i, s, wordDict, wordMem)) {
        wordMem.put(s.substring(now), true);
        return true;
      }
    }
    wordMem.put(s.substring(now), false);
    return false;
  }
}
