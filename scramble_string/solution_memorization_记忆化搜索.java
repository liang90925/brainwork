//暴力recursive

public class Solution {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() != s2.length()) {
      return false;
    }
    int len = s1.length();
    int[][][] visit = new int[len][len][len + 1];
    return checkScramble(s1, 0, s2, 0, len, visit);
  }
  private boolean checkScramble(String s1, int start1, String s2, int start2, int k, int[][][] visit) {
    if (visit[start1][start2][k] == 1) {
      return true;
    }
    if (visit[start1][start2][k] == -1) {
      return false;
    }
    if (s1.length() != s2.length()) {
      visit[start1][start2][k] = -1;
      return false;
    }
    if (s1.length() == 0 || s1.equals(s2)) {
      visit[start1][start2][k] = 1;
      return true;
    }
    if (!isValid(s1, s2)) {
      visit[start1][start2][k] = -1;
      return false;
    }

    for (int i = 1; i < s1.length(); i++) {
      String s11 = s1.substring(0, i);
      String s12 = s1.substring(i);

      String s21 = s2.substring(0, i);
      String s22 = s2.substring(i);

      String s23 = s2.substring(0, s2.length() - i);
      String s24 = s2.substring(s2.length() - i);

      if (checkScramble(s11, start1, s21, start2, i, visit) &&
          checkScramble(s12, start1 + i, s22, start2 + i, k - i, visit)) {
        visit[start1][start2][k] = 1;
        return true;
      }
      if (checkScramble(s11, start1, s24, start2 + k - i, i, visit) &&
          checkScramble(s12, start1 + i, s23, start2, k - i, visit)) {
        visit[start1][start2][k] = 1;
        return true;
      }
    }
    visit[start1][start2][k] = -1;
    return false;
  }

  private boolean isValid(String s1, String s2) {
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();

    Arrays.sort(c1);
    Arrays.sort(c2);
    if (!Arrays.equals(c1, c2)) {
      return false;
    }
    return true;
  }
}
