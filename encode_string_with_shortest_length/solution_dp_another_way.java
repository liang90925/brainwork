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
        // use another way to find the duplicate, see the readme for details
        String replace = "";
        int nextInx = (subStr + subStr).indexOf(subStr, 1);
        if (nextInx >= subStr.length()) {
          replace = subStr;
        } else {
          replace = String.format("%d[%s]", subStr.length() / nextInx , dp[i][i + nextInx - 1]);
        }
        if (replace.length() < dp[i][j].length()) {
          dp[i][j] = replace;
        }
      }
    }
    return dp[0][sLen - 1];
  }
}
