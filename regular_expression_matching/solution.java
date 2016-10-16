public class Solution{

  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    int sLth = s.length();
    int pLth = p.length();

    if (sLth == 0) {
      return isEmpty(p);
    }
    if (pLth == 0) {
      return false;
    }

    char s1 = s.charAt(0);
    char p1 = p.charAt(0), p2 = '0';

    if (pLth > 1) {
      p2 = p.charAt(1);
    }

    if (p2 == '*') {
      if (compare(s1, p1)) {
        // when s1 = p1, there can be two situations
        // first, move s to the next, and p keep at the same position;
        //        ex:  aaaaa, a*
        // second, s at the same position, but p move to the next one after *
        //        ex:   aa,   a*a
        return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
      } else {
        return isMatch(s, p.substring(2));
      }
    } else {
      if (compare(s1, p1)) {
        return isMatch(s.substring(1), p.substring(1));
      } else {
        return false;
      }
    }
  }

  private boolean compare(char c1, char c2) {
    return c2 == '.' || c1 == c2;
  }

  private boolean isEmpty(String p) {
    if (p.length()%2 != 0) {
      return false;
    }
    for (int i = 1; i < p.length(); i += 2) {
      if (p.charAt(i) != '*') {
        return false;
      }
    }
    return true;
  }

}
