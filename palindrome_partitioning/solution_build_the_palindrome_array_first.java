public class Solution {
  public List<List<String>> partition(String s) {
    if (s == null || s.length() == 0) {
      return Collections.emptyList();
    }
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] isPalindrome = isPalindrome(s);
    helper(s, 0, path, result, isPalindrome);
    return result;
  }

  private boolean[][] isPalindrome(String s) {
    int sLen = s.length();
    boolean[][] isPalindrome = new boolean[sLen][sLen];

    for (int j = 0; j < sLen; j++) {
      for (int i = j; i >= 0; i--) {
        if ((i + 1 >= j - 1 || isPalindrome[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
          isPalindrome[i][j] = true;
        }
      }
    }
    return isPalindrome;
  }

  private void helper(String s, int index, List<String> path, List<List<String>> result, boolean[][] isPalindrome) {
    if (index == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }

    for (int i = index + 1; i <= s.length(); i++) {
      String subStr = s.substring(index, i);
      if (!isPalindrome[index][i - 1]) {
        continue;
      }
      path.add(subStr);
      helper(s, i, path, result, isPalindrome);
      path.remove(path.size() - 1);
    }
  }
}
