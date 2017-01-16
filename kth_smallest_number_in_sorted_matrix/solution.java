// 总时间复杂度 O((n+m)log(maxValue - minValue))

public class Solution {

  class ResultType {
    public int num;
    public boolean exists;

    public ResultType(boolean e, int` n) {
      exists = e;
      num = n;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int m = matrix[0].length;
    int left = matrix[0][0];
    int right = matrix[n - 1][m - 1];

    // binary search
    // left + 1 < right
    while (left <= right) {
      int mid = left + (right - left) / 2;
      ResultType type = check (mid, matrix);
      if (type.exists && type.num == k) {
        return mid;
      } else if (type.num < k) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  //复杂度（n + m)
  private ResultType check (int value, int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    boolean exists = false;
    int num = 0;
    //从左下角开始走的 往右上角走
    int i = n -1, j = 0;
    while (i >= 0 && j < m) {
      if (matrix[i][j] == value) {
        exists = true;
      }
      if (matrix[i][j] <= value) {
        num += i + 1;
        j += 1;
      } else {
        i -= 1;
      }
    }
    return new ResultType(exists, num);
  }
}
