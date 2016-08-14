public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Integer> numsTreeSet = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      if (numsTreeSet.ceiling(x) != null && numsTreeSet.ceiling(x) <= x + t) {
        return true;
      }
      if (numsTreeSet.floor(x) != null && x <= t + numsTreeSet.floor(x)) {
        return true;
      }
      numsTreeSet.add(x);
      if (numsTreeSet.size() > k) {
        numsTreeSet.remove(nums[i-k]);
      }
    }
    return false;
  }
}
