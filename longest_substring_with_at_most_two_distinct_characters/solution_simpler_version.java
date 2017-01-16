public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() <= 0) {
      return 0;
    }
    int start = 0;
    int end = start + 1;

    char ch1 = s.charAt(0);
    char ch2 = '#';

    int result = 0;
    while (end <= s.length()) {
      // since end will be outof index, at this situation, just calculate the curren len and compare with the result
      if (end == s.length()) {
        result = Math.max(result, end - start);
        end++;
        continue;
      }
      // when we just met the second diff character, assign it to ch2 and continue;
      if (s.charAt(end) != ch1 && ch2 == '#') {
        ch2 = s.charAt(end);
      // when we have two diff char and just met the third one, we can calculate the max len at that time and compare with prev result
      // and then find the next start index and assing to start, and assign new ch1 and ch2;
      } else if (s.charAt(end) != ch1 && s.charAt(end) != ch2) {
        result = Math.max(result, end - start);

        char prev = s.charAt(end - 1);
        int j = end - 2;
        while (j >= 0 && s.charAt(j) == prev) {
          j--;
        }
        start = j + 1;
        ch1 = s.charAt(start);
        ch2 = s.charAt(end);
      }
      end++;
    }
    return result;
  }
}
