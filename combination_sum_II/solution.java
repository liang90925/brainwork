public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
      return Collections.emptyList();
    }

    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    helper(candidates, target, 0, path, result);
    return result;
  }

  private void helper(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList(path));
    }
    if (target < 0 || index >= candidates.length) {
      return;
    }
    int prev = -1;
    for (int i = index; i < candidates.length; i++) {
      if (candidates[i] != prev) {
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i + 1, path, result);
        path.remove(path.size() - 1);
        prev = candidates[i];
      }
    }
  }
}
