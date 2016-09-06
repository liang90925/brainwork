public class Solution {
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    s = s.replace(" ", "");
    int lth = s.length();
    Stack<Long> stk = new Stack<>();
    String firstNum = getNum(0, s);
    stk.push(Long.parseLong(firstNum));

    int i = firstNum.length();

    while (i < lth) {
      char c = s.charAt(i);
      // get the next number
      String nextNum = getNum(i + 1, s);
      if (c == '+') {
        stk.push(Long.parseLong(nextNum));
      }
      if (c == '-') {
        stk.push(-Long.parseLong(nextNum));
      }
      if (c == '*') {
        stk.push(stk.pop() * Long.parseLong(nextNum));
      }
      if (c == '/') {
        stk.push(stk.pop() / Long.parseLong(nextNum));
      }
      i = i + nextNum.length() + 1;
    }

    long result = 0;
    while (!stk.isEmpty()) {
      result += stk.pop();
    }

    return (int) result;
  }
  private String getNum(int index, String s) {
    StringBuilder sb = new StringBuilder();
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
      sb.append(s.charAt(index));
      index++;
    }
    return sb.toString();
  }
}
