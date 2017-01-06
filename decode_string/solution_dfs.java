public class Solution {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        int num = 0;
        // got the num before '['
        while (Character.isDigit(s.charAt(i))) {
          num = num * 10 + (int) (s.charAt(i++) - '0');
        }
        // now char at i is '[', add 1 to move to the letter.
        i++;
        int strStart = i;
        int count = 1; // means 1 number of '['
        // find the ']' that match the current '['
        while(count != 0) {
          if (s.charAt(i) == '[') {
            count++;
          } else if (s.charAt(i) == ']') {
            count--;
          }
          i++;
        }
        i--;
        // find the string starting from the '['
        String postStr = decodeString(s.substring(strStart, i));

        for (int j = 0; j < num; j++) {
          sb.append(postStr);
        }
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
