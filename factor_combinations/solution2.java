public class Solution {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    dfs(n, 2, list, result);
    return result;
  }
  private void dfs(int n, int start, List<Integer> list, List<List<Integer>> result) {
    if (n == 1) {
      if (list.size() > 1) {
        result.add(new ArrayList<>(list));
      }
      return;
    }
    for (int i = start; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        list.add(i);
        dfs(n / i, i, list, result);
        list.remove(list.size() - 1);
      }
    }
    list.add(n);
    dfs(1, n, list, result);
    list.remove(list.size() - 1);
  }
}
