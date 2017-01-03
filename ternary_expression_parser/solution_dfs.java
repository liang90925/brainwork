public class Solution {
  public String parseTernary(String expression) {
    if (expression == null | expression.length() <= 4) {
      return "";
    }

    return dfs(expression, 0, expression.length() - 1) + "";
  }

  private char dfs(String expression, int start, int end) {
    if (start == end) {
      return expression.charAt(start);
    }
    // following for loop is trying to find the ":" that match the current first "?"
    // so that we can seperate the expression into the true and false part for further dfs
    int count = 0, i = start;
    for (; i <= end; i++) {
      if (expression.charAt(i) == '?') {
        count++;
      }
      if (expression.charAt(i) == ':') {
        count--;
        if (count == 0) {
          break;
        }
      }
    }

    return expression.charAt(start) == 'T' ?
      dfs(expression, start + 2, i - 1) : dfs(expression, i + 1, end);
  }
}
