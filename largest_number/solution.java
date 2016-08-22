public class NumbersComparator implements Comparator<String> {
  @Override
  public int compare(String s1, String s2) {
    return (s2 + s1).compareTo(s1 + s2);
  }
}
public class Solution {
  public String largestNumber(int[] nums) {
    String[] numsString = new String[nums.length];
    int i = 0
    for (int num : nums) {
      numsString[i++] = String.valueOf(num);
    }

    Arrays.sort(strs, new NumbersComparator());
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
