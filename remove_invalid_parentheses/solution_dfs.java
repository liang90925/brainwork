public class Solution {
  private int maxPair = 0;
  private List<String> result = new ArrayList<>();
  public List<String> removeInvalidParentheses(String s) {
    dfs(s, "", 0, 0);
    if (result.size() == 0) {
      result.add("");
    }
    return result;
  }

  private void dfs(String restString, String newString, int leftCountDiff, int maxLeftCount) {
    if (restString.length() == 0) {
      if (leftCountDiff == 0 && newString.length() != 0) {
        if (maxLeftCount > maxPair) {
          maxPair = maxLeftCount;
        }
        if (maxLeftCount == maxPair && !result.contains(newString)) {
          result.add(newString);
        }
      }
      return;
    }

    if (restString.charAt(0) == '(') {
      dfs(restString.substring(1), newString + '(', leftCountDiff + 1, maxLeftCount + 1);
      dfs(restString.substring(1), newString, leftCountDiff, maxLeftCount);
    } else if (restString.charAt(0) == ')') {
      if (leftCountDiff > 0) {
        dfs(restString.substring(1), newString + ')', leftCountDiff - 1, maxLeftCount);
      }
      dfs(restString.substring(1), newString, leftCountDiff, maxLeftCount);
    } else {
      dfs(restString.substring(1), newString + restString.charAt(0), leftCountDiff, maxLeftCount);
    }
  }
}
