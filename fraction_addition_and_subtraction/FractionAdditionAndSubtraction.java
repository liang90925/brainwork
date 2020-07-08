import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction {
    /**
     * @param expression: a string
     * @return: return a string
     */
    public String fractionAddition(String expression) {
        // write your code here
        List<String> expressions = new ArrayList<>();
        int i = 1;
        int start = 0;
        while (i <= expression.length()) {
            if (i == expression.length() || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                if (expression.charAt(start) == '+') {
                    expressions.add(expression.substring(start + 1, i));
                } else {
                    expressions.add(expression.substring(start, i));
                }
                start = i;
            }
            i++;
        }
        // Updated expressions
//        System.out.println("=============");
//        expressions.forEach(System.out::println);
        String result = "0/1";

        for (String num: expressions) {
            result = add(result, num);
        }
        return result;
    }

    private String add(String num1, String num2) {
        int n1 = Integer.parseInt(num1.split("/")[0]);
        int d1 = Integer.parseInt(num1.split("/")[1]);
        int n2 = Integer.parseInt(num2.split("/")[0]);
        int d2 = Integer.parseInt(num2.split("/")[1]);
//        System.out.println("------------------");
//        System.out.println(n1 + ", " + d1 + ", " + n2+ ", " + d2);

        int n = n1 * d2 + n2 * d1;
        int d = d1 * d2;
  //      System.out.println(n + ", " + d);

        if (n == 0) {
            return "0/1";
        }
        boolean isNegative = n * d < 0;

        int maxCom = getMaxCom(n, d);
        String num = Math.abs(n / maxCom) + "/" + Math.abs(d / maxCom);

        return isNegative ? "-" + num : num;
    }

    private int getMaxCom(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return getMaxCom(b, a % b);
    }

    public static void main(String[] args) {
        FractionAdditionAndSubtraction solution = new FractionAdditionAndSubtraction();
        System.out.println(solution.fractionAddition("-1/2+1/2") + " === 0/1");
        System.out.println(solution.fractionAddition("-1/2+1/2+1/3") + " === 1/3");
        System.out.println(solution.fractionAddition("1/3-1/2") + " === -1/6");
        System.out.println(solution.fractionAddition("5/3+1/3") + " === 2/1");


//        System.out.println(solution.add("1/3", "-1/2"));
//        System.out.println(solution.add("-1/2", "1/2"));
//        System.out.println(solution.add("1/3", "1/2"));
//        System.out.println(solution.add("2/3", "2/4"));
    }
}
