
public class Solution {

  private boolean[][] palindromeCheck(String s) {
    if (s == null) {
      return new boolean[0][0];
    }
    int sLen = s.length();
    boolean[][] isPalindrome = new boolean[sLen][sLen];

    for (int i = 0; i < sLen; i++) {
      isPalindrome[i][i] = true;
    }

    for (int i = 0; i < sLen - 1; i++) {
      isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
    }

    for (int length = 2; length < sLen; length++) {
      for (int start = 0; start + length < sLen; start++) {
        isPalindrome[start][start + length] =
          isPalindrome[start + 1][start + length - 1] &&
          s.charAt(start) == s.charAt(start + length);
      }
    }
    return isPalindrome;
  }

  public int minCut(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    // build up the palindrome check 2d array
    boolean[][] isPalindrome = palindromeCheck(s);
    int sLen = s.length();

    // cutCount[i] represent the min cut needed at i len of S;
    // cutCount[sLen] will be the final result
    int[] minCut = new int[sLen + 1];
    for (int i = 0; i <= sLen; i++) {
      minCut[i] = i - 1;
    }

    // Note: 注意这里i 和 j的取法，很巧妙
    for (int i = 1; i <= sLen; i++) {
      for (int j = 0; j < i; j++) {
        if (isPalindrome[j][i - 1]) {
          minCut[i] = Math.min(minCut[i], minCut[j] + 1);
        }
      }
    }
    return minCut[sLen];
  }
}
