public class Solution {
  private int maxPair = 0;
  private int size = 0;
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
          if (size == 0) {
            size = newString.length();
          }
        }
      }
      return;
    }

    int currSize = restString.length() + newString.length();
    if (restString.charAt(0) == '(') {
      if (currSize >= size) {
        dfs(restString.substring(1), newString + '(', leftCountDiff + 1, maxLeftCount + 1);
      }
      if (currSize - 1 >= size) {
        dfs(restString.substring(1), newString, leftCountDiff, maxLeftCount);
      }
    } else if (restString.charAt(0) == ')') {
      if (leftCountDiff > 0 && currSize >= size) {
        dfs(restString.substring(1), newString + ')', leftCountDiff - 1, maxLeftCount);
      }
      if (currSize - 1 >= size) {
        dfs(restString.substring(1), newString, leftCountDiff, maxLeftCount);
      }
    } else {
      dfs(restString.substring(1), newString + restString.charAt(0), leftCountDiff, maxLeftCount);
    }
  }
}
