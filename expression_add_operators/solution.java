public class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    // NOTE: don't use StringBuilder since needs to set it's length everytime to make sure it won't continue to append
    // Therefore use "" would be a better solution
    helper(result, num, target, 0, 0L, 0L, "");
    return result;
  }

  // pos is here to mark where is the start point of the num we are working on
  // prevRes is the number we have before we +/-/* the curr value
  // prevNum is the number we previously +/-/* to build the prevRes; This is useful in the following situation:
  //   previous expression is 2 + 3; at that time, 5 is prevRes, 3 is prevNum when we met the next Num 4;
  //   since the new expression needs to be 2 + 3 * 4; we need to cal it as (5 - 3) + 3 * 4;
  //   which is (prevRes - prevNum) + prevNum * currNum, this will be the prevRes for next function
  //   and the prevNum becomes prevNum * currNum
  private void helper(List<String> result, String num, int target, int pos, long prevRes, long prevNum, String expression) {
    // when we reached the end of the num and also the result is equal to the target
    // we then add the built expression to the result
    if (pos == num.length() && prevRes == target) {
      result.add(expression);
      return;
    }

    for (int i = pos; i < num.length(); i++) {
      String currStr = num.substring(pos, i + 1);
      // to ignore the case where we have 0 as the beginning char and still has follow up numbers;
      // ex: "00", "01", "0..."
      if (currStr.charAt(0) == '0' && currStr.length() > 1) {
        break;
      }

      // use long type incase we have overflow in Int type
      long currNum = Long.parseLong(currStr);

      // when we start the expression, we should not add any expression so we need to have ifelse check here
      if (pos == 0) {
        helper(result, num, target, i + 1, currNum, currNum, expression + currStr);
      } else {
        helper(result, num, target, i + 1, prevRes + currNum, currNum, expression + '+' + currStr);
        helper(result, num, target, i + 1, prevRes - currNum, -currNum, expression + '-' + currStr);
        helper(result, num, target, i + 1, (prevRes - prevNum) + prevNum * currNum, prevNum * currNum, expression + '*' + currStr);
      }
    }
  }
}
