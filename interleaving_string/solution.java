public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    if (s3 == null) {
      return s1 == null && s2 == null;
    }
    if (s1 == null) {
      return (s2 == null && s3 == null) || s2.equals(s3);
    }
    if (s2 == null) {
      return (s1 == null && s3 == null) || s1.equals(s3);
    }
    int s1Len = s1.length();
    int s2Len = s2.length();
    if ((s1.length() + s2.length()) != s3.length()) {
      return false;
    }

    boolean[][] interleaved = new boolean[s1Len + 1][s2Len + 1];
    interleaved[0][0] = true;

    for (int i = 0; i < s1Len; i++) {
      if (s1.charAt(i) == s3.charAt(i) && interleaved[i][0]) {
        interleaved[i + 1][0] = true;
      }
    }

    for (int i = 0; i < s2Len; i++) {
      if (s2.charAt(i) == s3.charAt(i) && interleaved[0][i]) {
        interleaved[0][i + 1] = true;
      }
    }

    for (int i = 1; i <= s1Len; i++) {
      for (int j = 1; j <= s2Len; j++) {
        if (((s3.charAt(i + j - 1) == s1.charAt(i - 1)) && interleaved[i - 1][j]) ||
            ((s3.charAt(i + j - 1) == s2.charAt(j - 1)) && interleaved[i][j - 1])) {
          interleaved[i][j] = true;
        }
      }
    }
    return interleaved[s1Len][s2Len];
  }
}
