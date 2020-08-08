import java.util.Stack;

public class BasicCalculator {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    // remove all spaces using replace
    s = s.replace(" ", "");

    int lth = s.length();
    int i = 0;
    int sign = 1;
    int result = 0;
    Stack<Integer> signStack = new Stack<>();
    signStack.push(1);

    while (i < lth) {
      char c = s.charAt(i);
      // assign correct sign for the sign character.
      if (c == '+') {
        sign = 1;
        i++;
      } else if (c == '-') {
        sign = -1;
        i++;
      // situation for left and right bracket.
      } else if (c == '(') {
        signStack.push(sign * signStack.peek());
        sign = 1;
        i++;
      } else if (c == ')') {
        signStack.pop();
        i++;
      // the char is a digit
      } else {
        int num = 0;
        while (i < lth && Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
          i++;
        }
        result += num * sign * signStack.peek();
      }
    }
    return result;
  }
}
