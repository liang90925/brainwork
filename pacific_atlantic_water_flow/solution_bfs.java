public class Solution {
  private static final int[] X_RANGE = {1, -1, 0, 0};
  private static final int[] Y_RANGE = {0, 0, 1, -1};
  int row;
  int col;
  public List<int[]> pacificAtlantic(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }
    row = matrix.length;
    col = matrix[0].length;

    // create two 2d array to store the visited info and can flow info
    boolean[][] pacific = new boolean[row][col];
    boolean[][] atlantic = new boolean[row][col];
    Queue<Integer> pQueue = new LinkedList<>();
    Queue<Integer> aQueue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      pacific[i][0] = true;
      atlantic[i][col - 1] = true;
      pQueue.offer(i * col);
      aQueue.offer(i * col + col - 1);
    }

    for (int i = 0; i < col; i++) {
      pacific[0][i] = true;
      atlantic[row - 1][i] = true;
      pQueue.offer(0 * col + i);
      aQueue.offer((row - 1) * col + i);
    }

    bfs(pacific, pQueue, matrix);
    bfs(atlantic, aQueue, matrix);

    List<int[]> points = new ArrayList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          int[] point = {i, j};
          points.add(point);
        }
      }
    }

    return points;
  }

  private void bfs(boolean[][] visited, Queue<Integer> queue, int[][] matrix) {
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      int i = curr / col;
      int j = curr % col;
      for (int k = 0; k < 4; k++) {
        int x = i + X_RANGE[k];
        int y = j + Y_RANGE[k];
        // NOTE! : 注意这些条件，不要忘记visited 和 matrix的判断
        if (x < 0 || x >= row || y < 0||y >= col || visited[x][y] || matrix[i][j] > matrix[x][y]) {
          continue;
        }
        queue.offer(x * col + y);
        visited[x][y] = true;
      }
    }
    return;
  }
}
