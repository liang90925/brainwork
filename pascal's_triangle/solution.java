public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    if (numRows == 0) {
      return result;
    }

    List<Integer> first = new ArrayList<>();
    first.add(1);
    result.add(first);

    for (int i = 1; i < numRows; i++) {
      List<Integer> temp = new ArrayList<>(i + 1);

      for (int j = 0; j < i + 1; j++) {
        temp.add(-1);
      }

      List<Integer> prev = result.get(i - 1);
      temp.set(0, prev.get(0));
      temp.set(i, prev.get(i - 1));

      for (int j = 1; j < i; j++) {
        temp.set(j, prev.get(j - 1) + prev.get(j));
      }
      result.add(temp);
    }
    return result;
  }
}
