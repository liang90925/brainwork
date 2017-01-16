public class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0 <= k ? 0 : Integer.MIN_VALUE;
    }

    // need to get the smaller num from col and row and loop from the small one
    int row = matrix.length;
    int col = matrix[0].length;
    int N = Math.max(row, col);
    int M = Math.min(row, col); // smaller one loop first
    boolean isRowSmaller = row <= col ? true : false;

    int result = Integer.MIN_VALUE;
    // loop over Dimenstion 1
    for (int i = 0; i < M; i++) {
      int[] sumList = new int[N];
      // loop over Dimension 1 for i
      for (int j = i; j >= 0; j--) {
        // loop over Dimension 2 for i
        for (int l = 0; l < N; l++) {
          sumList[l] += isRowSmaller ? matrix[j][l] : matrix[l][j];
        }
        result = Math.max(result, getLargestSumCloseToK(sumList, k));
      }
    }
    return result;
  }
  // find the max value of a continuous elements in sumList that <= k;
  private int getLargestSumCloseToK(int[] sumList, int k) {
    int result = Integer.MIN_VALUE;
    int sum = 0;
    TreeSet<Integer> set = new TreeSet<>();
    // add 0 first, for situation when sum - k <= 0 that means, sum it self is good to meet the requirement
    set.add(0);

    for (int i = 0; i < sumList.length; i++) {
      sum += sumList[i];
      Integer ceiling = set.ceiling(sum - k);
      if (ceiling != null) {
        result = Math.max(result, sum - ceiling);
      }
      set.add(sum);
    }
    return result;
  }
}
