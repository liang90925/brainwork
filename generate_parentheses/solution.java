public class Solution {
  public List<String> generateParenthesis(int n) {
    if (n <= 0) {
      return Collections.emptyList();
    }

    List<String> result = new ArrayList<>();
    String parenthesis = "";
    helper(parenthesis, result, n, n);
    return result;
  }

  private void helper(String parenthesis, List<String> result, int left, int right) {
    if (left == 0 && right == 0) {
      result.add(parenthesis);
      return;
    }
    if (left > 0) {
      helper(parenthesis + "(", result, left - 1, right);
    }
    if (right > 0 && left < right) {
      helper(parenthesis + ")", result, left, right - 1);
    }
  }
}
