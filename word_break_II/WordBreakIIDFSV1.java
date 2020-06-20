import java.util.*;
// still use the DFS to go through all  combinations, but can build boolean arrays to faciliate it
// so that we can skip many impossible combinations.

public class WordBreakIIDFSV1 {
  public List<String> wordBreak(String s, Set<String> wordDict) {
    if (s == null || s.length() == 0 || wordDict == null) {
      return Collections.emptyList();
    }
    Map<String, List<String>> strMap = new HashMap<>();

    return search(s, wordDict, strMap);
  }

  private List<String> search(String s,  Set<String> wordDict, Map<String, List<String>> strMap) {
    if (strMap.containsKey(s)) {
      return strMap.get(s);
    }

    ArrayList<String> results = new ArrayList<>();

    if (s.length() == 0) {
      return results;
    }
    if (wordDict.contains(s)) {
      results.add(s);
    }

    // dfs part with pruning（剪枝）
    for (int i = 1; i <= s.length(); i++) {
      String prefix = s.substring(0, i);
      String suffix = s.substring(i);
      if (!wordDict.contains(prefix)) {
        continue;
      }
      // When prefix is in the dict check the rest
      List<String> restSegments = search(suffix, wordDict, strMap);
      for(String segment: restSegments) {
        String newFormat = prefix + " " + segment;
        results.add(newFormat);
      }
    }
    strMap.put(s, results);
    return results;
  }
}
