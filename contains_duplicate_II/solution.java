public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> numsSet = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (numsSet.contains(nums[i])) {
        return true;
      }
      numsSet.add(nums[i]);
      if (numsSet.size() > k) {
        numsSet.remove(nums[i - k]);
      }
    }

    return false;
  }
}
