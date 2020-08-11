import java.util.*;

public class BasicCalculatorIIINewWayImproved {
    private static final Map<Character, Integer> OPERATOR_PRECEDENTS = new HashMap<Character, Integer>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
        put(')', 0);
        put('(', 0);
    }};

    public int calculate(String s) {
        // Write your code hereif
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.replace(" ", "");

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();
        int num;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = ch - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + s.charAt(i) - '0';
                }
                numStack.push(num);
            } else if (ch == '(') { //注意 check （） 一定要在其他符号之前
                opsStack.push(ch);
            } else if (ch == ')') {
                while (opsStack.peek() != '(') {
                    evaluateTop(numStack, opsStack);
                }
                opsStack.pop(); // pop out '(';
//            } else if (OPERATOR_PRECEDENTS.containsKey(ch)) {
            } else { //只需要 else 了 因为就剩下这些
                while (!opsStack.isEmpty() && OPERATOR_PRECEDENTS.get(opsStack.peek()) >= OPERATOR_PRECEDENTS.get(ch)) {
                    evaluateTop(numStack, opsStack);
                }
                opsStack.push(ch);
            }
        }

        while (!opsStack.isEmpty()) {
            evaluateTop(numStack, opsStack);
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
        BasicCalculatorIIINewWayImproved solution = new BasicCalculatorIIINewWayImproved();
       // System.out.println(solution.findTheOtherP("1+2*(5-3*(3-3))-89", 10));
        System.out.println("======================");
  //      System.out.println(solution.calculate("1+2") +  " === 3");
 //       System.out.println(solution.calculate("1 + 1") +  " === 2");
//        System.out.println(solution.calculate("12 + 2") +  " === 14");
//        System.out.println(solution.calculate("12 + 2 - 1") +  " === 13");
//        System.out.println(solution.calculate("12 + 2 - 2 * 3") +  " === 8");
//
//        System.out.println(solution.calculate("12 + 2 - 2 * 3 + 3/2") +  " === 9");
        System.out.println(solution.calculate("12 + (2 - 1) + 2") +  " === 15");

        System.out.println(solution.calculate("12 + (2 - 1*4) + 2") +  " === 12");
        System.out.println(solution.calculate("12 + (2 - 1*4 + 4/1) + 2") +  " === 16");

        System.out.println(solution.calculate("12 + (2 - 1*4 - 3*(2 -1)) + 2") +  " === 9");
        System.out.println(solution.calculate("12 + (2 - 1*4 - 3*(2 - 2*4)) + 2") +  " === 30");
        System.out.println(solution.calculate("12 + (2 - 1*4)*(1+1) + 2") +  " === 10");
    }
}
