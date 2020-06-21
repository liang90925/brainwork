import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesesRewrite {
  public List<String> generateParenthesis(int n) {
    if (n <= 0) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    helper(n, n, "", result);
    return result;
  }

  private void helper(int left, int right, String form, List<String> result) {
    if (left == 0 && right == 0) {
      result.add(form);
      return;
    }
    if (left > 0) {
      helper(left - 1, right, form + "(", result);
    }

    if (right > left) {
      helper(left, right - 1, form + ")", result);
    }
  }
}
