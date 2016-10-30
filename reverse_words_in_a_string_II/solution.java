// First reverse the s
// Second reverse each word in the s


public class Solution {
  public void reverseWords(char[] s) {
    if (s == null || s.length <= 1) {
      return;
    }
    reverseS(s, 0, s.length - 1);

    for (int i = 0, j =0; j <= s.length; j++) {
      if (s[j] == ' ' || j == s.length) {
        reverseS(s, i, j - 1);
        i = j + 1;
      }
    }
  }

  private void reverseS(char[] s, int start, int end) {
    while (start < end) {
      char temp = s[start];
      s[start] = s[end];
      s[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    char[] ch = {'b', 'l', 'u', 'e', ' ', 's', 'k', 'y'};
    s.reverseWords(ch);
    System.out.println(ch);
  }
}
