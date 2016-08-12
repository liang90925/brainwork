public class Solution {
  public String convert(String s, int numRows) {
    if (s == null || numRows <= 1 || s.length() <= numRows ){
      return s;
    }
    int length = s.length();
    char[] cResult = new char[length];
    int step = 2 * (numRows -1);
    int index = 0;
    for (int i = 0; i < numRows; i++) {
      int interval = step - 2 * i;
      for (int j = i; j < length; j+= step) {
        cResult[index] = s.charAt(j);
        index++;

        if (interval < length & interval > 0  && (j + interval) < length & index < length) {
          cResult[index] = s.charAt(j + interval);
          index++;
        }
      }
    }
    return new String(cResult);
  }
}
