
// refer to https://segmentfault.com/a/1190000002991199
// https://www.felix021.com/blog/read.php?2040

public class Solution {
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    String newStr = buildNewString(s);
    int[] maxBoundry = new int[newStr.length()];

    int currMidInd = 0;
    int currMaxBrdInd = 0;
    int maxInd = 0;
    int maxBdr = 0;

    for (int i = 1; i < newStr.length(); i++) {
      // j is the symmetry of i with currMidInd as the middle point
      int j = 2 * currMidInd - i;

      // 如果当前已知延伸的最右端大于当前下标，我们可以用对称点的P值，否则记为1等待检查
      if (currMaxBrdInd > i) {
        maxBoundry[i] = Math.min(maxBoundry[j], currMaxBrdInd - i);
      } else {
        maxBoundry[i] = 1;
      }

      // 检查并更新当前下标为中心的回文串最远延伸的长度
      while((i + maxBoundry[i]) < newStr.length()
      && newStr.charAt(i + maxBoundry[i]) == newStr.charAt(i - maxBoundry[i])) {
        maxBoundry[i]++;
      }

      // 检查并更新当前已知能够延伸最远的回文串信息
      if (i + maxBoundry[i] > currMaxBrdInd) {
        currMaxBrdInd = i + maxBoundry[i];
        currMidInd = i;
      }

      if (maxBoundry[i] > maxBdr) {
        maxBdr = maxBoundry[i];
        maxInd = i;
      }
    }

    // 去除占位符
    return s.substring((maxInd - maxBdr) / 2, (maxInd + maxBdr) / 2 - 1);
  }

  // get the palindrome centered with substr at start and end
  public String buildNewString(String s) {
    StringBuilder sb = new StringBuilder();
    sb.append("$");
    for (int i = 0; i < s.length(); i++) {
      sb.append("#");
      sb.append(s.charAt(i));
    }
    sb.append("#");
    return sb.toString();
  }
}
