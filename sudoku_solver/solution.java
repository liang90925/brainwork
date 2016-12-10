import java.util.*;

public class Solution {
  public void solveSudoku (char[][] board) {
    solve(board);
  }
  private boolean solve(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          continue;
        }

        for (int k = 1; k <= 9; k++) {
          board[i][j] = (char) (k + '0');
          if (isValid(board, i, j) && solve(board)) {
            return true;
          }
          board[i][j] = '.';
        }
        return false;
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int x, int y) {
    // check row;
    for (int i = 0; i < 9; i++) {
      if (i != y && board[x][i] == board[x][y]) {
        return false;
      }
    }

    // check col;
    for (int i = 0; i < 9; i++) {
      if (i != x && board[x][y] == board[i][y]) {
        return false;
      }
    }


    // check block;
    for (int i = x/3 * 3; i < x/3 * 3 + 3; i++) {
      for (int j = y/3 * 3; j < y/3 * 3 + 3; j++) {
        if (i != x && j!= y && board[i][j] == board[x][y]) {
          return false;
        }
      }
    }

    return true;
  }
}
