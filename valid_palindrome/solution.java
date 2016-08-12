public class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() <=0) {
      return true;
    }
    int start = 0;
    int end = s.length() - 1;

    while (start < end) {
      while (start < s.length() && !isvalid(s.charAt(start))) {
        start++;
      }
      while (end >= 0 && !isvalid(s.charAt(end))) {
        end--;
      }
      if (Character.toUpperCase(s.charAt(start)) == Character.toUpperCase(s.charAt(end))) {
        start++;
        end--;
      } else {
        break;
      }
    }
    return end <= start;
  }
  public boolean isValid(char c) {
    return Character.isLetter(c) || Character.isDigit(c);
  }
}
