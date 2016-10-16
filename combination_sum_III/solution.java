public class Solution {
  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    helper(k, n, 1, path, result);
    return result;
  }
  private static void helper(int k, int target, int index, List<Integer> path, List<List<Integer>> result) {
    if (target < 0) {
        return;
    }
    if (target == 0 && path.size() == k) {
      result.add(new ArrayList(path));
      return;
    }

    for (int i = index; path.size() < k && i <= 9; i++) {
      path.add(i);
      helper(k, target - i, i + 1, path, result);
      path.remove(path.size() - 1);
    }
  }
}
