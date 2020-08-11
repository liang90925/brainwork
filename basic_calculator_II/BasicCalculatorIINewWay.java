import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BasicCalculatorIINewWay {
    private static final Set<Character> OPERATORS= new HashSet<>(Arrays.asList(
            '+', '-', '*', '/'
    ));
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // remove all spaces using replace
        s = s.replace(" ", "");

        int len = s.length();
        int i = 0;
        Stack<Character> signStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num;
        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // Get the num;
                num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(num);
            } else if (OPERATORS.contains(c)) {
                while (!signStack.isEmpty() && isPrecedent(signStack.peek(), c)) {
                    numStack.push(calculate(numStack.pop(), numStack.pop(), signStack.pop()));
                }
                signStack.push(c);
                i++;
            }
        }

        while (!signStack.isEmpty()) {
            numStack.push(calculate(numStack.pop(), numStack.pop(), signStack.pop()));
        }
        return numStack.pop();
    }

    public int calculate(int b, int a, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    public boolean isPrecedent(char pre, char post) {
        if ((pre == '+' || pre == '-') && (post == '*' || post == '/')) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        BasicCalculatorIINewWay solution = new BasicCalculatorIINewWay();
        System.out.println(solution.calculate("3/2 "));
        System.out.println(solution.calculate("3 + 2*2 "));
        System.out.println(solution.calculate("3+5/2 "));
        System.out.println(solution.calculate("3-6*2/3-1+2 "));
    }
}
