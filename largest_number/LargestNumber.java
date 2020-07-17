import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] numsString = new String[nums.length];
    int i = 0;
    for (int num : nums) {
      numsString[i++] = String.valueOf(num);
    }
    Arrays.sort(numsString, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
    if (numsString[0].equals("0")) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (String s : numsString) {
      sb.append(s);
    }
    return sb.toString();
  }
}
