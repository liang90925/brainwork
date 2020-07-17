// time and space complexity: 0(n^2)

public class LongestPalindromeSubstringRewrite {
  public String longestPalindrome(String s) {
    if (s == null || s.length() <= 0) {
      return s;
    }
    int len = s.length();
    // 2 DP????
    boolean[][] isPalindrome = new boolean[len][len];
    int max = 0;
    int[] maxCoord = new int[2];
    for (int j = 0; j < len; j++) {
      for (int i = 0; i <= j; i++) {
        if (i == j) {
          isPalindrome[i][j] = true;
        } else if (j - i <= 2) {
          isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
        }
        if (isPalindrome[i][j] && j - i + 1 > max) {
          max = j - i + 1;
          maxCoord[0] = i;
          maxCoord[1] = j;
        }
      }
    }
    return s.substring(maxCoord[0], maxCoord[1] + 1);
  }

  public static void main(String[] args) {
    LongestPalindromeSubstringRewrite solution = new LongestPalindromeSubstringRewrite();
    System.out.println(solution.longestPalindrome("babad") + " === bab");
    System.out.println(solution.longestPalindrome("cbbd") + " === bb");
    System.out.println(solution.longestPalindrome("abc") + " === bab");
    System.out.println(solution.longestPalindrome("bbcbbcacbbcabbac") + " === cbbcacbbc");

  }
}
