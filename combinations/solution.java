public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    if (n < k) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    helper(n, k, 1, list, result);
    return result;
  }

  private void helper(int n, int k, int index, List<Integer> list, List<List<Integer>> result) {
    if (list.size() == k) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i <= n; i++) {
      list.add(i);
      helper(n, k, i + 1, list, result);
      list.remove(list.size() - 1);
    }
  }
}
