import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Digit could be double
// Elements are always separated by spaces
public class BasicCalculatorCustomizedQuestion {
    private static final Map<Character, Integer> OPERATOR_PRECEDENTS = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put(')', 0);
        put('(', 0);
    }};

    public double calculate(String s) {
        // Write your code hereif
        if (s == null || s.length() == 0) {
            return 0;
        }

        String[] sstr = s.split("\\s+");

//        if (!isValidExpression(sstr)) {
//            return 0;
//        }

        Stack<Double> numStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();

        for (String curr : sstr) {
            if (!isOperator(curr)) {
                // This is a digit value
                numStack.push(Double.parseDouble(curr));
            } else if (curr.charAt(0) == '(') { //注意 check （） 一定要在其他符号之前
                opsStack.push(curr.charAt(0));
            } else if (curr.charAt(0) == ')') {
                while (opsStack.peek() != '(') {
                    evaluateTop(numStack, opsStack);
                }
                opsStack.pop(); // pop out '(';
//            } else if (OPERATOR_PRECEDENTS.containsKey(ch)) {
            } else { //只需要 else 了 因为就剩下这些
                while (!opsStack.isEmpty()
                        && OPERATOR_PRECEDENTS.get(opsStack.peek()) >= OPERATOR_PRECEDENTS.get(curr.charAt(0))) {
                    evaluateTop(numStack, opsStack);
                }
                opsStack.push(curr.charAt(0));
            }
        }

        while (!opsStack.isEmpty()) {
            evaluateTop(numStack, opsStack);
        }
        return numStack.pop();
    }

    /**
     * 这个方程没有写正确。。。。。。。。。
     * @param strings
     * @return
     */
    private boolean isValidExpression(String[] strings) {
        String prev = "";

        for (int i = 0; i < strings.length; i++) {
            String curr = strings[i];
            if (isOperator(curr)) {
                if (i != 0) {
                    prev = strings[i - 1];
                    if (isOperator(prev)) {
                        if (prev.charAt(0) != ')' || curr.charAt(0) != '(') {
                            return false;
                        }
                    } else if (!isOperator(prev)) {
                        if (curr.charAt(0) == '(') {
                            return false;
                        }
                    }
                } else {
                    if (!isBrackets(curr)) {
                        return false;
                    }
                }
            } else {
                try {
                    double value = Double.parseDouble(curr);
                    if (i != 0) {
                        prev = strings[i - 1];
                        if (!isOperator(prev) || prev.charAt(0) == ')') {
                            return false;
                        }
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isOperator(String s) {
        return s.length() == 1 && OPERATOR_PRECEDENTS.containsKey(s.charAt(0));
    }

    private boolean isBrackets(String s) {
        return s.length() == 1 && (s.charAt(0) == '(' || s.charAt(0) == ')');
    }

    private void evaluateTop(Stack<Double> numStack, Stack<Character> signStack) {
        numStack.push(calculate(numStack.pop(), numStack.pop(), signStack.pop()));
    }

    public double calculate(double b, double a, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        BasicCalculatorCustomizedQuestion solution = new BasicCalculatorCustomizedQuestion();
       // System.out.println(solution.findTheOtherP("1+2*(5-3*(3-3))-89", 10));

        System.out.println(solution.calculate("12 + ( 2.5 - 2 * 4.3 + 4 / 2.5 ) + 2") +  " === 9.5");
        System.out.println(solution.calculate("12 + ( 2.5 - 2 * 4.3 + -4 / 2.5 ) + 2") +  " === 6.3");

        System.out.println("======================");
        System.out.println(solution.calculate("1  +  2") +  " === 3");
        System.out.println(solution.calculate("1 + 1") +  " === 2");
        System.out.println(solution.calculate("12 + 2") +  " === 14");
        System.out.println(solution.calculate("12 + 2 - 1") +  " === 13");
        System.out.println(solution.calculate("12 + 2 - 2 * 3") +  " === 8");
        System.out.println(solution.calculate("12 + 2 - 2 * 3 + 3 / 2") +  " === 9");
        System.out.println(solution.calculate("12 + ( 2 - 1 ) + 2") +  " === 15");

        System.out.println(solution.calculate("12 + ( 2 - 1 * 4 ) + 2") +  " === 12");
        System.out.println(solution.calculate("12 + ( 2 - 1 * 4 + 4 / 1 ) + 2") +  " === 16");

        System.out.println(solution.calculate("12 + ( 2 - 1 * 4 - 3 * ( 2 - 1 ) ) + 2") +  " === 9");
        System.out.println(solution.calculate("12 + ( 2 - 1 * 4 - 3 * ( 2 - 2 * 4 ) ) + 2") +  " === 30");
        System.out.println(solution.calculate("12 + ( 2 - 1 * 4 ) * ( 1  + 1 ) + 2") +  " === 10");
    }
}
