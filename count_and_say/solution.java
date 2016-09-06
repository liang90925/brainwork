public class Solution {
  public String countAndSay(int n) {
    String preStr = "";
    if (n <= 0) {
      return preStr;
    }
    preStr = "1";

    while(--n > 0) {
      StringBuilder sb = new StringBuilder();
      char[] preChar = preStr.toCharArray();

      for (int i = 0; i < preChar.length; i++) {
        int count = 1;
        while ((i + 1) < preChar.length && preChar[i + 1] == preChar[i]) {
          i++;
          count++;
        }
        sb.append(String.valueOf(count) + String.valueOf(preChar[i]));
      }
      preStr = sb.toString();
    }
    return preStr;
  }
}
