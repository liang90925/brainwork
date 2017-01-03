public class Solution {
  public String parseTernary(String expression) {
    if (expression == null | expression.length() <= 4) {
      return "";
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      stack.push(expression.charAt(i));
    }
    while (stack.size() > 1) {
      int i = 4;
      char[] exp = new char[5];
      while (!stack.isEmpty() && i >= 0) {
        exp[i] = stack.pop();
      }
      if (isValidExpression(exp)) {
        char newCh = caculateExpression(exp);
        stack.push(newCh);
      } else {
        for (; i < 5; i++) {
          stack.push(exp[i]);
        }
      }
    }
    return Integer.valueOf(stack.pop());
  }
  private boolean isValidExpression(char[] ch) {
    if (ch.length != 5) {
      return false;
    }
    if (ch[0] != 'T' || ch[0] != 'F' || ch[1] != '?' || ch[3] != ':') {
      return false;
    }
    int num1 = ch[2] - '0';
    int num2 = ch[2] - '9';
    if (num1 < 0 || num1 > 9 || num2 < 0 || num2 >9) {
      return false;
    }
    return true;
  }
  private char caculateExpression(char[] ch) {
    if (ch[0] == 'T') {
      return ch[2];
    } else {
      return ch[4];
    }
  }
}
