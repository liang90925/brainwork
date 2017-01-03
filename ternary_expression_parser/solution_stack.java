public class Solution {
  public String parseTernary(String expression) {
    if (expression == null | expression.length() <= 4) {
      return "";
    }
    Stack<Character> stack = new Stack<>();
    for (int i = expression.length() - 1; i >= 0; i--) {
      if (stack.size() > 0 && stack.peek() == '?') {
        stack.pop();  // pop out the '?'
        char ch1 = stack.pop();
        stack.pop(); // pop out the ':'
        char ch2 = stack.pop();
        if (expression.charAt(i) == 'T') {
          stack.push(ch1);
        } else {
          stack.push(ch2);
        }
      } else {
        stack.push(expression.charAt(i));
      }
    }
    return String.valueOf(stack.peek());
  }
}
