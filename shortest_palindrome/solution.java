// This is a O(n^2) method
public class Solution {
  public String shortestPalindrome(String s) {
    // pre check
    if (s == null || s.length() <= 1) { return s;}

    int len = s.length();
    int j = len;

    StringBuilder sb = new StringBuilder();

    // similar to having a pointer move from end to begin
    // break when find the first palindrome.
    while (j > 1) {
      String subStr = s.substring(0, j);
      if(isPalindrome(subStr)) {
        sb = sb.append(s.substring(j, len)).reverse();
        break;
      }
      j--;
    }

    // didn't find a palindrome in the given string`
    if (sb.length() == 0) {
      sb = sb.append(s.substring(j, len)).reverse();
    }

    // append original string and conver to string
    return sb.append(s).toString();
  }
  private boolean isPalindrome(String s) {
    for (int i = 0; i < s.length()/2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
