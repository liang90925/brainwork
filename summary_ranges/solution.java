public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    int lth = nums.length, start = 0, end = start + 1;
    while (end < lth) {
      while ((end < lth) && (nums[end] == nums[end - 1] + 1)) {
        end++;
      }
      if ((end - 1) > start) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(nums[start]))
          .append("->")
          .append(String.valueOf(nums[end - 1]));
        result.add(sb.toString());
      } else {
        result.add(String.valueOf(nums[start]));
      }
      start = end;
      end = start + 1;
    }
    if (start == lth - 1) {
      result.add(String.valueOf(nums[start]));
    }
    return result;
  }
}
