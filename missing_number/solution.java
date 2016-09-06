public class Solution {
  public int missingNumber(int[] nums) {
    return (int) (nums.length * (nums.length + 1) * 0.5 - Arrays.stream(nums).sum());
  }
}
