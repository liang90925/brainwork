import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  private final static int[] moveX = {-1, 1, 0, 0};
  private final static int[] moveY = {0, 0, -1, 1};

  public int shortestDistance(int[][] grid) {
    if (grid == null || grid[0].length == 0) {
      return -1;
    }
    int row = grid.length;
    int col = grid[0].length;

    //记录到各个building的距离和
    int[][] dist = new int[row][col];

    //记录能到达building的个数
    int[][] nums = new int[row][col];
    int buildingNum = 0;

    // loop through the grid and find the building, start BFS from the biulding
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          buildingNum++;
          bfs(grid, i, j, dist, nums);
        }
      }
    }

    int minDist = Integer.MAX_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        // 记住要加上dist[i][j] != 0 去排除buildings和blocks
        // 还有一点要注意的是nums[i][j] == buildingNum 才让dist与最小值比较
        // 但是如果 nums[i][j] != buildingNum 并不代表此时应该返回-1， 只是当前的点不能到所有的而建筑物
        // 只有当所有的0点不能全部到达所有建筑物的时候才return -1， 这点在最后return时被check
        if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum) {
          minDist = Math.min(minDist, dist[i][j]);
        }
      }
    }
    //此处还是要判断是不是max值 以免input出现[[1]]和所有0点不能到达所有建筑物
    return minDist == Integer.MAX_VALUE ? -1: minDist;
  }

  private void bfs(int[][] grid, int m, int n, int[][] dist, int[][] nums) {
    int row = grid.length;
    int col = grid[0].length;

    Queue<int[]> que = new LinkedList<>();
    que.add(new int[]{m, n});

    //记录访问过的grid里面为0的点；
    boolean[][] visited = new boolean[row][col];
    int step = 0;
    while (!que.isEmpty()) {
      step++;
      int size = que.size();
      for (int i = 0; i < size; i++) {
        int[] curr = que.poll();
        for (int j = 0; j < 4; j++) {
          int x = curr[0] + moveX[j];
          int y = curr[1] + moveY[j];
          if (x >=0 && x < row && y >= 0 && y < col
                  && !visited[x][y] && grid[x][y] == 0) {
            visited[x][y] = true;
            dist[x][y] += step;
            nums[x][y]++;
            que.add(new int[]{x, y});
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Solution sl = new Solution();
    int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    System.out.println(sl.shortestDistance(grid));
  }
}
