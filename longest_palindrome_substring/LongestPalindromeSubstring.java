// time and space complexity: 0(n^2)

public class LongestPalindromeSubstring {
  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 0) {
      return s;
    }

    int len = s.length();
    boolean[][] palindrome = new boolean[len][len];
    String result = s.substring(0, 1);

    for (int j = 0; j < len; j++) {
      palindrome[j][j] = true;

      for (int i = 0; i < j; i++) {
        if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || palindrome[i + 1][j - 1])) {
          palindrome[i][j] = true;

          if (j - i + 1 > result.length()) {
            result = s.substring(i, j + 1);
          }
          continue;
        }
      }
    }
    return result;
  }
}
