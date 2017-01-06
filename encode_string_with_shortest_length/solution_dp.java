public class Solution {
  public String encode(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    int sLen = s.length();
    // create a two D array dp[i][j] to represent the minLenght String from index i of string to index j
    String[][] dp = new String[sLen][sLen];

    for (int step = 0; step < sLen; step++) {
      for (int i = 0; i + step < sLen; i++) {
        int j = i + step;
        String subStr = s.substring(i, j + 1);
        dp[i][j] = subStr;
        // check if string length < 5, In that case, encode won't help
        if (j - i < 4) {
          continue;
        }
        // loop for trying all results that we get after dividing the strings into 2
        // and combine the   results of 2 substrings
        for (int k = i; k < j; k++) {
          if ((dp[i][k] + dp[k+ 1][j]).length() < dp[i][j].length()) {
            dp[i][j] = dp[i][k] + dp[k+1][j];
          }
        }

        // Loop for checking if string can itself found some pattern in it which could be repeated.
        int subLen = subStr.length();
        for (int k = 0; k < subStr.length(); k++) {
          String repeatStr = subStr.substring(0, k + 1);
          int repeatStrLen = repeatStr.length();
          if (repeatStr != null && subLen % repeatStrLen == 0 && subStr.replaceAll(repeatStr, "").length() == 0) {
            String encoded = String.format("%d[%s]", subLen / repeatStrLen, dp[i][i + k]);
            if (encoded.length() < dp[i][j].length()) {
              dp[i][j] = encoded;
            }
          }
        }
      }
    }

    return dp[0][sLen - 1];
  }
}
