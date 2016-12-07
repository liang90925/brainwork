import java.util.*;

public class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }
    int count = 0;
    int row = matrix.length;
    int col = matrix[0].length;

    while (count *  2 < row && count * 2 < col) {
      for (int i = count; i < col - count; i++) {
        result.add(matrix[count][i]);
      }
      for (int i = count + 1; i < row - count; i++) {
        result.add(matrix[i][col - count - 1]);
      }
      if (row - 2 * count == 1 || col - 2 * count == 1) {
        // if only one row or col is left, no need to do the remaining two for loops
        break;
      }
      for (int i = col - count - 2; i >= count; i--) {
        result.add(matrix[row - count - 1][i]);
      }
      for (int i = row - count - 2; i >= count + 1; i--) {
        result.add(matrix[i][count]);
      }
      count++;
    }
    return result;
  }
}
