// simpler version
public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    int lth = nums.length, start = 0, end = 0;
    while (end < lth) {
      if (end + 1 < lth && nums[end] + 1 == nums[end + 1]) {
        end++;
      } else {
        if (start == end) {
          result.add(String.valueOf(nums[start]));
        } else {
          result.add(nums[start] + "->" + nums[end]);
        }
        start = end + 1;
        end = start;
      }
    }
    return result;
  }
}
