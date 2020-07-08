import java.util.Stack;

public class BasicCalculatorIII {
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
    public int calculateNoP(String s) {
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
                System.out.println("new substring in () ---> " + s.substring(i + 1, endingIndex) );
                int numInP = calculateNoP(s.substring(i + 1, endingIndex));
                System.out.println("value in new substring ---> " + numInP);
                if (sign == '+') {
                    stack.push(numInP);
                }
                if (sign == '-') {
                    stack.push(-numInP);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * numInP);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / numInP);
                }
                i = endingIndex + 1;
                if (i < len && !Character.isDigit(s.charAt(i))) {
                    sign = s.charAt(i);
                    i++;
                }
            } else {
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
                i++;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        BasicCalculatorIII solution = new BasicCalculatorIII();
//        System.out.println(solution.findTheOtherP("1+2*(5-3*(3-3))-89", 10));
//        System.out.println("======================");
//        System.out.println(solution.calculateNoP("1+2") +  " === 3");
//        System.out.println(solution.calculateNoP("12 + 2") +  " === 14");
//        System.out.println(solution.calculateNoP("12 + 2 - 1") +  " === 13");
//        System.out.println(solution.calculateNoP("12 + 2 - 2 * 3") +  " === 8");
//
//        System.out.println(solution.calculateNoP("12 + 2 - 2 * 3 + 3/2") +  " === 9");
        System.out.println(solution.calculateNoP("12 + (2 - 1) + 2") +  " === 15");

        System.out.println(solution.calculateNoP("12 + (2 - 1*4) + 2") +  " === 12");
        System.out.println(solution.calculateNoP("12 + (2 - 1*4 + 4/1) + 2") +  " === 16");

        System.out.println(solution.calculateNoP("12 + (2 - 1*4 - 3*(2 -1)) + 2") +  " === 9");
        System.out.println(solution.calculateNoP("12 + (2 - 1*4 - 3*(2 - 2*4)) + 2") +  " === 30");
        System.out.println(solution.calculateNoP("12 + (2 - 1*4)*(1+1) + 2") +  " === 10");

    }
}


//    /**
//     * @param s: the expression string
//     * @return: the answer
//     */
//    public int calculate(String s) {
//        // Write your code here
//
//        // Store values within the parenthesis
//        Stack<String> stk1 = new Stack<>();
//
//        // Store values outside the parenthesis;
//        Stack<Integer> stk2 = new Stack<>();
//
//        int num = 0;
//        String sign = "+";
//
//        int idx = 0;
//        while(idx < s.length()) {
//            // digit
//            if (Character.isDigit(s.charAt(idx))) {
//                num = num * 10 + s.charAt(idx) - '0';
//
//                // plus sign
//            } else if (s.charAt(idx) == '+'){
//                if (sign.equals("-")) {
//                    num = -1 * num;
//                }
//                sign = "+";
//                stk2.push(num);
//                num = 0;
//
//                // minus sign
//            } else if (s.charAt(idx) == '-'){
//                if (sign.equals("-")) {
//                    num = -1 * num;
//                }
//                sign = "-";
//                stk2.push(num);
//                num = 0;
//            } else if (s.charAt(idx) == '(') {
//                int tempSum = 0;
//                while (!stk2.isEmpty()) {
//                    tempSum += stk2.pop();
//                }
//                stk1.push(String.valueOf(tempSum));
//                stk1.push(sign);
//            } else if (s.charAt(idx) == '*') {
//                int val = stk2.pop();
//                val *= num;
//                stk2.push(val);
//                num = 0;
//            } else if (s.charAt(idx) == '/') {
//                int val = stk2.pop();
//                val /= num;
//                stk2.push(val);
//                num = 0;
//            } else if (s.charAt(idx) == ')') {
//                int tempSum = 0;
//                while (!stk2.isEmpty()) {
//                    tempSum += stk2.pop();
//                }
//
//            } else if (s.charAt(idx) == ' ') {
//                continue;
//            }
//        }
//    }