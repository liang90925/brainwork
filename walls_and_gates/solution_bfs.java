public class Solution {
  private static final int[] X_RANGE = {1, -1, 0, 0};
  private static final int[] Y_RANGE = {0, 0, 1, -1};

  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
      return;
    }
    int row = rooms.length;
    int col = rooms[0].length;

    Queue<Integer> que = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (rooms[i][j] == 0) {
          que.offer(i * col + j);
        }
      }
    }

    while (!que.isEmpty()) {
      int size = que.size();
      for (int i = 0; i < size; i++) {
        int curr = que.poll();
        int x = curr / col;
        int y = curr % col;
        for (int k = 0; k < 4; k++) {
          int newX = x + X_RANGE[k];
          int newY = y + Y_RANGE[k];
          if (newX < 0 || newY < 0 || newX >= row || newY >= col || rooms[newX][newY] <= rooms[x][y]) {
            continue;
          }
          rooms[newX][newY] = rooms[x][y] + 1;
          que.offer(newX * col + newY);
        }
      }
    }
  }
}
