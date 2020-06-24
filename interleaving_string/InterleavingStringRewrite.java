public class InterleavingStringRewrite {
  public boolean isInterleave(String s1, String s2, String s3) {
    int len1 = s1.length();
    int len2 = s2.length();
    int len3 = s3.length();
    if (len1 + len2 != len3) {
      return false;
    }

    boolean[][] interleaveDp = new boolean[len1 + 1][len2 + 1];
    interleaveDp[0][0] = true;

    for (int i = 1; i <= len1; i++) {
      interleaveDp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
    }
    for (int i = 1; i <= len2; i++) {
      interleaveDp[0][i] = s2.substring(0, i).equals(s3.substring(0,i));
    }

    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        interleaveDp[i][j] =
                (s1.charAt(i - 1) == s3.charAt(i + j - 1) && interleaveDp[i - 1][j])
                || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && interleaveDp[i][j - 1]);
      }
    }
    return interleaveDp[len1][len2];
  }

  public static void main(String[] args) {
    InterleavingStringRewrite solution = new InterleavingStringRewrite();
    System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbcbcac")  + " === true");
    System.out.println(solution.isInterleave("aabcc", "dbbca", "aadbbbaccc")  + " === false");
    System.out.println(solution.isInterleave("", "", "1")  + " === false");
  }
}
