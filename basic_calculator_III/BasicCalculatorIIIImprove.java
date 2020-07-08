import java.util.Stack;

public class BasicCalculatorIIIImprove {

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

        int i = 0;
        while (i < len) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                i++;
                if (i != len) {
                    continue;
                } else {
                    i--;
                }
            }

            if (s.charAt(i) == '(') {
                int endingIndex = findTheOtherP(s, i + 1);
                num = calculate(s.substring(i + 1, endingIndex));
                i = endingIndex + 1;
            }

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
            if (i < len) {
                sign = s.charAt(i);
            }
            num = 0;
            i++;
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    // startIdx is where the '(' is;
    private int findTheOtherP(String s, int startIdx) {
        int cnt = 1;
        for (int i = startIdx; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }
            if (s.charAt(i) == ')') {
                cnt--;
            }
            if (cnt == 0) {
                return i;
            }
        }
        return s.length() - 1;
    }

    public static void main(String[] args) {
        BasicCalculatorIIIImprove solution = new BasicCalculatorIIIImprove();
        System.out.println(solution.findTheOtherP("1+2*(5-3*(3-3))-89", 10));
        System.out.println("======================");
        System.out.println(solution.calculate("1+2") +  " === 3");
        System.out.println(solution.calculate("12 + 2") +  " === 14");
        System.out.println(solution.calculate("12 + 2 - 1") +  " === 13");
        System.out.println(solution.calculate("12 + 2 - 2 * 3") +  " === 8");

        System.out.println(solution.calculate("12 + 2 - 2 * 3 + 3/2") +  " === 9");
        System.out.println(solution.calculate("12 + (2 - 1) + 2") +  " === 15");

        System.out.println(solution.calculate("12 + (2 - 1*4) + 2") +  " === 12");
        System.out.println(solution.calculate("12 + (2 - 1*4 + 4/1) + 2") +  " === 16");

        System.out.println(solution.calculate("12 + (2 - 1*4 - 3*(2 -1)) + 2") +  " === 9");
        System.out.println(solution.calculate("12 + (2 - 1*4 - 3*(2 - 2*4)) + 2") +  " === 30");
        System.out.println(solution.calculate("12 + (2 - 1*4)*(1+1) + 2") +  " === 10");
    }
}
