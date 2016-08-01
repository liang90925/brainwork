public class Solution {
  public boolean isMatch(String s, String p) {
    int sl = s.length();
    int pl = p.length();
    int si = 0;
    int pi = 0;
    int star = -1;
    int mark = -1;

    while (si < sl) {
      if (pi < pl && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')) {
        si++;
        pi++;
      }
      if (pi < pl && p.charAt(pi) == '*') {
        star = pi++;
        mark = si;
      } else if (star != -1) {
        pi = star + 1;
        si = ++mark;
      } else {
        return false;
      }
    }

    while (pi < pl && p.charAt(pi) == '*') {
      pi++;
    }
    return pi == pl;
  }
}
