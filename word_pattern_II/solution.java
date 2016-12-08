
public class Solution {
  public boolean wordPatternMatch(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    if (pattern == null || str == null) {
      return false;
    }
    return dfs(pattern, 0, str, 0, set, map);
  }

  public boolean dfs(String pattern, int pInx, String str, int sInx, Set<String> set, Map<Character, String> map) {
    if (pInx == pattern.length() && sInx == pattern.length()) {
      return true;
    }
    if (pInx == pattern.length() || sInx == pattern.length()) {
      return false;
    }
    char patternC = pattern.charAt(pInx);
    if (map.containsKey(patternC)) {
      String value = map.get(patternC);
      if (value.equals(str.substring(sInx, sInx + value.length()))) {
        return dfs(pattern, pInx + 1, str, sInx + value.length(), set, map);
      } else {
        return false;
      }
    }

    for (int i = sInx; i < str.length(); i++) {
      String subStr = str.substring(sInx, i + 1);
      if (set.contains(subStr)) {
        continue;
      }
      // create or update it
      map.put(patternC, subStr);
      set.add(subStr);

      if (dfs(pattern, pInx + 1, str, i + 1, set, map)) {
        return true;
      }
      map.remove(patternC);
      set.remove(subStr);
    }
    return false;
  }
}
