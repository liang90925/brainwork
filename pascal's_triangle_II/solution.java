public class Solution {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new ArrayList<>();
    if (rowIndex < 0) {
      return result;
    }
    result.add(1);
    rowIndex++;

    for (int i = 1; i < rowIndex; i++) {
      List<Integer> temp = new ArrayList<>();

      for (int j = 0; j < i + 1; j++) {
        temp.add(-1);
      }
      temp.set(0, result.get(0))
    }
  }
}
