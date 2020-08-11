import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelElement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BasicCalculatorIIINewWay {
    private static final Set<Character> OPERATORS= new HashSet<>(Arrays.asList(
            '+', '-', '*', '/'
    ));

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
            } else if (OPERATORS.contains(ch)) {
                while (!opsStack.isEmpty() && isPrecedent(opsStack.peek(), ch)) {
                    numStack.push(calculate(numStack.pop(), numStack.pop(), opsStack.pop()));
                }
                opsStack.push(ch);
            } else if (ch == '(') {
                opsStack.push(ch);
            } else if (ch == ')') {
                while (opsStack.peek() != '(') {
                    numStack.push(calculate(numStack.pop(), numStack.pop(), opsStack.pop()));
                }
                opsStack.pop(); // pop out '(';
            }
        }

        while (!opsStack.isEmpty()) {
            numStack.push(calculate(numStack.pop(), numStack.pop(), opsStack.pop()));
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
        if (pre == '(' || pre == ')') {
            return false;
        }

        if ((pre == '+' || pre == '-') && (post == '*' || post == '/')) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        BasicCalculatorIIINewWay solution = new BasicCalculatorIIINewWay();
       // System.out.println(solution.findTheOtherP("1+2*(5-3*(3-3))-89", 10));
        System.out.println("======================");
  //      System.out.println(solution.calculate("1+2") +  " === 3");
 //       System.out.println(solution.calculate("1 + 1") +  " === 2");
//        System.out.println(solution.calculate("12 + 2") +  " === 14");
//        System.out.println(solution.calculate("12 + 2 - 1") +  " === 13");
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
