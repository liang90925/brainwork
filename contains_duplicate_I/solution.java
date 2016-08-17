public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> numsSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) return true;
      numsSet.add(nums[i]);
    }
    return false;
  }
}
