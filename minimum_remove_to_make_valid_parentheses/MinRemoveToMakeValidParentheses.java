import java.util.Stack;

public class MinRemoveToMakeValidParentheses {

  public String minRemoveToMakeValid(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    int sLen = s.length();
    Stack<Integer> parenthesesStc = new Stack<>();
    boolean[] inxsToRemove = new boolean[sLen];
    for (int i = 0; i <sLen; i++) {
      if (s.charAt(i) == '(') {
        parenthesesStc.push(i);
      }
      if (s.charAt(i) == ')') {
        if (parenthesesStc.empty()) {
          inxsToRemove[i] = true;
        } else {
          parenthesesStc.pop();
        }
      }
    }
    while (!parenthesesStc.empty()) {
      int index = parenthesesStc.pop();
      inxsToRemove[index] = true;
    }

    StringBuilder strBuilder = new StringBuilder();
    for(int i = 0; i < sLen; i++) {
      if (!inxsToRemove[i]) {
        strBuilder.append(s.charAt(i));
      }
    }
    return strBuilder.toString();
  }

  public static void main(String[] args) {
    MinRemoveToMakeValidParentheses toTest = new MinRemoveToMakeValidParentheses();
    String test1 = "lee(t(c)o)de)";
    System.out.println("===========================");
    System.out.println("test1: " + test1);
    System.out.println("result: " + toTest.minRemoveToMakeValid(test1));

    String test2 = "a)b(c)d";
    System.out.println("===========================");
    System.out.println("test2: " + test2);
    System.out.println("result: " + toTest.minRemoveToMakeValid(test2));

    String test3 = "))((";
    System.out.println("===========================");
    System.out.println("test3: " + test3);
    System.out.println("result: " + toTest.minRemoveToMakeValid(test3));

    String test4 = "(a(b(c)d)";
    System.out.println("===========================");
    System.out.println("test4: " + test4);
    System.out.println("result: " + toTest.minRemoveToMakeValid(test4));
  }
}
