public class Solution {
  public void generateTargetArrray(int[] targetArray, String t) {
    for (char ch : t.toCharArray()) {
      targetArray[ch]++;
    }
  }

  public boolean validateSource(int[] sourceArray, int[] targetArray) {
    for (int i = 0; i < 256; i++) {
      if (targetArray[i] > sourceArray[i]) {
        return false;
      }
    }
    return true;
  }
  public String minWindow(String s, String t) {
    if (s == null || s.length() <= 0 || t == null || t.length() <= 0) {
      return null;
    }

    int[] targetArray = new int[256];
    int[] sourceArray = new int[256];

    int i = 0, j = 0;
    int resultLen = Integer.MAX_VALUE;
    String resultStr = "";
    int sLen = s.length();
    generateTargetArrray(targetArray, t);

    for (i = 0; i < sLen; i++) {
      while (!validateSource(sourceArray, targetArray) && j < sLen) {
        sourceArray[s.charAt(j)]++;
        j++;
      }
      if (validateSource(sourceArray, targetArray)) {
        if (resultLen > j - i) {
          resultLen = j - i;
          resultStr = s.substring(i, j);
        }
      }
      sourceArray[s.charAt(i)]--;
    }
    return resultStr;
  }
}
