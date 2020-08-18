import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateRPN {
    Set<String> OPERATORS = new HashSet<String>(){{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN(String[] tokens) {
        Stack<Integer> intStk = new Stack<>();
        for (String token: tokens) {
            if (!OPERATORS.contains(token)) {
                intStk.push(Integer.valueOf(token));
            } else {
                int right = intStk.pop();
                int left = intStk.pop();
                intStk.push(calculate(left, right, token.charAt(0)));
            }
        }
        return intStk.pop();

    }

    public int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
        }
        return 0;
    }
}
