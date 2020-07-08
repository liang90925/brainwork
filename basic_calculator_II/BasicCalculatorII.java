import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Stack;

public class BasicCalculatorII {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code hereif
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.replace(" ", "");

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int len = s.length();

        for (int i = 0;i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == len - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }

        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculatorII solution = new BasicCalculatorII();
        System.out.println(solution.calculate("3/2 "));
    }
}
