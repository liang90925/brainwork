import java.util.Stack;

public class BasicCalculatorRewrite {


  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    // remove all spaces using replace
    s = s.replace(" ", "");

    int len = s.length();
    int i = 0;
    int result = 0;
    Stack<Character> signStack = new Stack<>();
    Stack<Integer> numStack = new Stack<>();

    while (i < len) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        // Get the num;
        int num = 0;
        while (i < len && Character.isDigit(s.charAt(i))) {
          num = num * 10 + s.charAt(i) - '0';
          i++;
        }

        if (signStack.isEmpty() || signStack.peek() == '(') {
          numStack.push(num);
        } else {
          int pre = numStack.pop();
          char sign = signStack.pop();
          numStack.push(calculate(pre, num, sign));
        }

      } else if (c == '+' || c == '-' || c == '(') {
        signStack.push(c);
        i++;
      } else if (c == ')') {
        signStack.pop(); // this will pop out the )
        while (!signStack.isEmpty() && signStack.peek() != '(') {
          int post = numStack.pop();
          int pre = numStack.pop();
          char sign = signStack.pop();
          numStack.push(calculate(pre, post, sign));
        }
        i++;
      }
    }
    return numStack.pop();
  }

  public int calculate(int left, int right, char sign) {
    switch (sign) {
      case '+': return left + right;
      case '-': return left - right;
    }
    return 0;
  }

  public static void main(String[] args) {
    BasicCalculatorRewrite basicCalculator = new BasicCalculatorRewrite();
    System.out.println(basicCalculator.calculate("1 + 1"));
    System.out.println(basicCalculator.calculate("2-1 + 2"));
    System.out.println(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));

  }
}
