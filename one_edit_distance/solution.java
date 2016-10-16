public class Solution {
  public boolean isOneEditDistance(String s, String t) {
    if (s == null || t == null) {
      return false;
    }

    int sLth = s.length();
    int tLth = t.length();

    if (sLth == tLth) {
      return isOneModified(s, t);
    }
    if ((sLth - tLth) == 1) {
      return isOneDeleted(s, t);
    }
    if ((tLth - sLth) == 1)  {
      return isOneDeleted(t, s);
    }
    return false;
  }

  private boolean isOneModified(String w1, String w2) {
    boolean modified = false;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i)) {
        if (modified) {
          return false;
        }
        modified = true;
      }
    }
    return modified;
  }

  private boolean isOneDeleted(String longer, String shorter) {
    for (int i = 0; i < shorter.length(); i++) {
      if (longer.charAt(i) != shorter.charAt(i)) {
        return longer.substring(i + 1).equals(shorter.substring(i));
      }
    }
    return true;
  }
}
