
public class Solution {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length < 9 || board.length > 9 ||
        board[0].length < 9 || board[0].length > 9) {
      return false;
    }

    boolean[] visited = new boolean[9];

    // check row;
    for (int i = 0; i < 9; i++) {
      // for a new row, clean up the visited array
      Arrays.fill(visited, false);
      for (int j = 0; j < 9; j++) {
        if (!isValid(board[i][j], visited)) {
          return false;
        }
      }
    }

    // check row;
    for (int i = 0; i < 9; i++) {
      // for a new col, clean up the visited array
      Arrays.fill(visited, false);
      for (int j = 0; j < 9; j++) {
        if (!isValid(board[j][i], visited)) {
          return false;
        }
      }
    }

    // check block
    // easy to messup, rewrite again to check
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        // for a new block, clean up the visited array
        Arrays.fill(visited, false);
        for (int k = 0; k < 9; k++) {
          if (!isValid(board[i + k / 3][j + k % 3], visited)) {
            return false;
          }
        }
      }
    }

    // don't forget that one
    return true;
  }

  private boolean isValid(char c, boolean[] visited) {
    if (c == '.') {
      return true;
    }
    int num = c - '0';
    if (num < 1 || num > 9 || visited[num - 1]) {
      return false;
    }
    visited[num - 1] = true;
    return true;
  }
}
