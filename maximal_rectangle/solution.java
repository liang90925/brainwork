public class Solution {
  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;

    // build a 2d matrix that stores the max height at row i and col j
    int[][] height = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0) {
          height[i][j] = (matrix[i][j] == '1') ? 1 : 0;
        } else {
          height[i][j] += ((matrix[i][j] == '1') ? height[i - 1][j] + 1 : 0);
        }
      }
    }

    int result = 0;

    // use the Largest Rectangle in Histogram technic to find the max rectangle in the metric;
    for (int i = 0; i < row; i++) {

      // check each row to find the max result for one row and compare with each each row
      Stack<Integer> stack = new Stack<>();
      for (int j = 0; j < col; j++) {
        while(!stack.isEmpty() && height[i][j] < height[i][stack.peek()]) {
          int pos = stack.peek();
          stack.pop();
          result = Math.max(result, height[i][pos] * (stack.isEmpty() ? j : j - stack.peek() - 1));
        }
        stack.push(j);
      }

      while (!stack.isEmpty()) {
        int pos = stack.peek();
        stack.pop();
        result = Math.max(result, height[i][pos] * (stack.isEmpty() ? col : col - stack.peek() - 1));
      }
    }
    return result;
  }
}
