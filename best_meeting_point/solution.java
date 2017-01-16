import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int row = grid.length;
    int col = grid[0].length;
    List<Integer> xRange = new ArrayList<>();
    List<Integer> yRange = new ArrayList<>();
    // put the x index where "1" showsup to a List
    // put the y index where "1" showsup to another List
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          xRange.add(i);
          yRange.add(j);
        }
      }
    }
    int sum = 0;
    int xMid = xRange.get(xRange.size() / 2);
    // yRange 是没有排序的，需要从大到小sort
    Collections.sort(yRange);
    int yMid = yRange.get(yRange.size() / 2);

    for (Integer index : xRange) {
      sum += Math.abs(index - xMid);
    }

    for (Integer index : yRange) {
      System.out.println(Math.abs(index - yMid));
      sum += Math.abs(index - yMid);
    }

    return sum;
  }

  public static void main(String[] args) {
    Solution sl = new Solution();
    int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    System.out.println(sl.minTotalDistance(grid));
  }
}
