//没写出来，不会
// brute force solution
//没写出来，不会
// brute force solution
public class Solution {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
      return 0;
    }
    int count1 = 0, count2 = 0, i = 0, j = 0;
    while (count1 < n1) {
      if (s1.charAt(i) == s2.charAt(j)) {
        j++;
        if (j == s2.length()) {
          j = 0;
          count2++;
        }
      }
      i++;
      if (i == s1.length()) {
        i = 0;
        count1++;
      }
    }
    return count2 / n2;
  }
}
