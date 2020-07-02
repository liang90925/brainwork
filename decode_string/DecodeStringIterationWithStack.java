import java.util.Stack;

public class DecodeStringIterationWithStack {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    char[] sChar = s.toCharArray();
    Stack<Integer> counts = new Stack<>();
    Stack<String> str = new Stack<>();
    String result = "";
    int i = 0;
    
    while (i < s.length()) {
      if (Character.isDigit(sChar[i])) {
        int num = 0;
        while (Character.isDigit(sChar[i])) {
          num = num * 10 + (int) (sChar[i++] - '0');
        }
        counts.push(num);
      } else if (sChar[i] == '[') {
        str.push(result);
        result = "";
        i++;
      } else if (sChar[i] == ']') {
        StringBuilder sb = new StringBuilder(str.pop());
        int count = counts.pop();
        for (int j = 0; j < count; j++) {
          sb.append(result);
        }
        result = sb.toString();
        i++;
      } else {
        result += sChar[i++];
      }
    }
    return result;
  }
}
