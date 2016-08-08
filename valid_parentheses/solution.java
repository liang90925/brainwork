public class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    String parantheses = "({[";
    for (char c:s.toCharArray()) {
      if (parantheses.contains(String.valueOf(c))) {
        stack.push(c);
      } else {
        if (!stack.empty() && validateParantheses(stack.peek(), c)) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.empty();
  }
  private boolean validateParantheses(char c1, char c2) {
    return (c1=='(' && c2==')') || (c1=='{' && c2=='}') || (c1=='[' && c2==']');
  }
}
