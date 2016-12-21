public class Solution {
  public List<List<String>> partition(String s) {
    if (s == null || s.length() == 0) {
      return Collections.emptyList();
    }
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    helper(s, 0, path, result);
    return result;
  }
  private void helper(String s, int index, List<String> path, List<List<String>> result) {
    if (index == s.length()) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int i = index + 1; i <= s.length(); i++) {
      String subStr = s.substring(index, i);
      if (!isPalindrome(subStr)) {
        continue;
      }
      path.add(subStr);
      helper(s, i, path, result);
      path.remove(path.size() - 1);
    }
  }
  private boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
