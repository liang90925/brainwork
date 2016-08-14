public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int lastRowLth = triangle.size();
    int[] resultArray = new int[lastRowLth];

    for (int i = 0 ; i < lastRowLth; i++) {
      resultArray[i] = triangle.get(lastRowLth - 1).get(i);
    }

    for (int i = lastRowLth - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        resultArray[j] = Math.min(resultArray[j], resultArray[j+1]) + triangle.get(i).get(j);
      }
    }

    return resultArray[0];
  }
}
