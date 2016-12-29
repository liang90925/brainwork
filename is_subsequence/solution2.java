public class Solution {
  public boolean isSubsequence(String s, String t) {
    int prev = 0;

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      prev = t.indexOf(ch, prev);
      if (prev == -1) {
        return false;
      }
      prev++;
    }
    return true;
  }
}
