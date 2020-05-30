import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  public String largestNumber(int[] nums) {
    String[] numsString = new String[nums.length];
    int i = 0;
    for (int num : nums) {
      numsString[i++] = String.valueOf(num);
    }

    Arrays.sort(numsString, new NumbersComparator());
    StringBuilder sb = new StringBuilder();
    for (String s : numsString) {
      sb.append(s);
    }
    String result = sb.toString();
    if (result.charAt(0) == '0') {
      return "0";
    }
    return result;
  }
}
