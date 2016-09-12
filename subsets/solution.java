public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums ==  null || nums.length == 0) {
      return result;
    }

    List<Integer> singleSet = new ArrayList<>();
    Arrays.sort(nums);

    subsetsHelper(result, singleSet, nums, 0);
    return result;
  }

  private void subsetsHelper(List<List<Integer>> result, List<Integer> singleSet,
  int[] nums, int startIndex) {
    result.add(new ArrayList<Integer>(singleSet));

    for (int i = startIndex; i < nums.length; i++) {
      singleSet.add(nums[i]);
      subsetsHelper(result, singleSet, nums, i + 1);
      singleSet.remove(singleSet.size() - 1);
    }
  }
}
