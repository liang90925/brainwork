public class ValidPalindromeII {
  public boolean validPalindrome(String s) {
    if (s == null) {
      return true;
    }
    return isValid(s, 0, s.length() - 1, 1);
  }

  public boolean isValid(String s, int left, int right, int remainingQuota) {
    if (remainingQuota <0) {
      return false;
    }

    while (left <= right) {
      if (s.charAt(left) != s.charAt(right)) {
        return isValid(s, left + 1, right, remainingQuota - 1)
                || isValid(s, left, right - 1, remainingQuota - 1);
      }
      left++;
      right--;
    }
    return true;
  }
}
