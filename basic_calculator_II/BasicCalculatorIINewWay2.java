import java.util.*;

public class BasicCalculatorIINewWay2 {
    private static final Map<Character, Integer> OPERATOR_PRECEDENTS = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};
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
            } else if (OPERATOR_PRECEDENTS.containsKey(c)) {
                while (!signStack.isEmpty() && OPERATOR_PRECEDENTS.get(signStack.peek()) >= OPERATOR_PRECEDENTS.get(c)) {
                    evaluateTop(numStack, signStack);
                }
                signStack.push(c);
                i++;
            }
        }

        while (!signStack.isEmpty()) {
            evaluateTop(numStack, signStack);
        }
        return numStack.pop();
    }

    private void evaluateTop(Stack<Integer> numStack, Stack<Character> signStack) {
        numStack.push(calculate(numStack.pop(), numStack.pop(), signStack.pop()));
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

    public static void main(String[] args) {
        BasicCalculatorIINewWay2 solution = new BasicCalculatorIINewWay2();
        System.out.println(solution.calculate("3/2 "));
        System.out.println(solution.calculate("3 + 2*2 "));
        System.out.println(solution.calculate("3+5/2 "));
        System.out.println(solution.calculate("3-6*2/3-1+2 "));
    }
}
