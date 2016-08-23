public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int i = 0;
    for ( ; i < v1.length && i < v2.length; i++) {
      int value1 = Integer.valueOf(v1[i]);
      int value2 = Integer.valueOf(v2[i]);
      if (value1 > value2) {
        return 1;
      }
      if (value2 > value1) {
        return -1;
      }
    }
    if (v1.length > v2.length) {
      for (; i < v1.length; i++) {
        if (Integer.valueOf(v1[i]) != 0) return 1;
      }
    }
    if (v2.length > v1.length {
      for (; i < v2.length; i++) {
        if (Integer.valueOf(v2[i]) != 0) return -1;
      }
    }
    return 0;
  }
}
