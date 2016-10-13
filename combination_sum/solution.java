public class Solution {
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> sums = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return sums;
    }
    List<Integer> path = new ArrayList<>();
    Arrays.sort(candidates);
    helper(candidates, target, 0, path, sums);
    return sums;
  }

  private static void helper(int[] candidates, int target, int index,
    List<Integer> path, List<List<Integer>> sums) {

    if (target == 0) {
      sums.add(new ArrayList(path));
      return;
    }

    int prev = -1;
    for (int i = index; i < candidates.length; i++) {
      if (candidates[i] > target) {
        break;
      }
      if (candidates[i] != prev) {
        path.add(candidates[i]);
        helper(candidates, target - candidates[i], i + 1, path, sums);
        path.remove(path.size() - 1);
        prev = candidates[i];
      }
    }
  }
}
