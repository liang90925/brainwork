import java.util.*;


public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    if (nums.length ==  0) {
      result.add(new ArrayList<>());
      return result;
    }

    List<Integer> single = new ArrayList<>();

    dfs(nums, single, result);
    return result;
  }

  private void dfs(int[] nums, List<Integer> single, List<List<Integer>> result) {
    if (single.size() == nums.length) {
      result.add(new ArrayList<>(single));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // NOTE: 此处的用法非常巧妙，用list的contain来保证选下一个。
      if (single.contains(nums[i])) {
        continue;
      }
      single.add(nums[i]);
      dfs(nums, single, result);
      single.remove(single.size() - 1);
    }
  }
}
