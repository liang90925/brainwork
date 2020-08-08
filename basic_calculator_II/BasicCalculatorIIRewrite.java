import java.util.Stack;

public class BasicCalculatorIIRewrite {
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

        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // Get the num;
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }

                if (!signStack.isEmpty() && (signStack.peek() == '*'  || signStack.peek() == '/')) {
                    int pre = numStack.pop();
                    char sign = signStack.pop();
                    numStack.push(calculate(pre, num, sign));

                } else {
                    numStack.push(num);
                }

            } else if (c == '+' || c == '-' || c == '*' || c == '/' ) {
                signStack.push(c);
                i++;
            }
        }

        if (signStack.isEmpty()) {
            return numStack.pop();
        }

        Stack<Character> invSignStack = new Stack<>();
        Stack<Integer> invNumStack = new Stack<>();
        while (!signStack.isEmpty()) {
            invSignStack.push(signStack.pop());
        }
        while (!numStack.isEmpty()) {
            invNumStack.push(numStack.pop());
        }

        int result = invNumStack.pop();
        while (!invSignStack.isEmpty()) {
            int post = invNumStack.pop();
            result = calculate(result, post, invSignStack.pop());
        }
        return result;
    }

    public int calculate(int left, int right, char sign) {
        switch (sign) {
            case '*': return left * right;
            case '/': return left / right;
            case '+': return left + right;
            case '-': return left - right;
        }
        return 0;
    }

    public static void main(String[] args) {
        BasicCalculatorIIRewrite solution = new BasicCalculatorIIRewrite();
        System.out.println(solution.calculate("3/2 "));
        System.out.println(solution.calculate("3 + 2*2 "));
        System.out.println(solution.calculate("3+5/2 "));
        System.out.println(solution.calculate("3-6*2/3-1+2 "));
    }
}
