public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() <= 0) {
      return 0;
    }
    int start = 0;
    int end = start + 1;
    int diff = 1;

    char ch1 = s.charAt(0);
    char ch2 = '#';

    int result = 0;
    while (end <= s.length()) {
      if (end == s.length()) {
        result = Math.max(result, end - start);
        end++;
        continue;
      }
      if (s.charAt(end) == ch1 || s.charAt(end) == ch2) {
        end++;
        continue;
      } else if (s.charAt(end) != ch1 && ch2 == '#') {
        ch2 = s.charAt(end);
        diff++;
      } else if (s.charAt(end) != ch1 && s.charAt(end) != ch2) {
        diff++;
      }
      if (diff > 2) {
        result = Math.max(result, end - start);

        char prev = s.charAt(end - 1);
        int j = end - 2;
        while (j >= 0 && s.charAt(j) == prev) {
          j--;
        }
        start = j + 1;
        ch1 = s.charAt(start);
        ch2 = s.charAt(end);
        diff = 2;
      }
      end++;
    }
    return result;
  }
}
