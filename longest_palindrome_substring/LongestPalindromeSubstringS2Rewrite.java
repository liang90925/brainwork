// O(n^2) TIME complexity O(1) SPACE complexity , better thant the dp version

public class LongestPalindromeSubstringS2Rewrite {
  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 0) {
      return s;
    }
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      // get palindrome centered at i
      String temp = getPalindrome(s, i, i);
      if (temp.length() > result.length()) {
        result = temp;
      }

      // get palindrome centered at i and i+1
      temp = getPalindrome(s, i, i + 1);
      if (temp.length() > result.length()) {
        result = temp;
      }
    }
    return result;
  }

  // get the palindrome centered with substr at start and end
  public String getPalindrome(String s, int start, int end) {
    while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
      start--;
      end++;
    }
    return s.substring(start + 1, end);
  }
}
