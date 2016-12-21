public class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        int cnt = map.get(c);
        map.put(c, cnt + 1);
      } else {
        map.put(c, 1);
      }

      while (map.size() > k) {
        maxLen = Math.max(maxLen, i - left);
        char leftC = s.charAt(left);
        if (map.get(leftC) == 1) {
          map.remove(leftC);
        } else {
          map.put(leftC, map.get(leftC) - 1);
        }
        left++;
      }
    }
    if (left < s.length()) {
      maxLen = Math.max(maxLen, s.length() - left);
    }
    return maxLen;
  }
}
