public class Solution {
  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return false;
    }
    if (word == null || word.length() == 0) {
      return true;
    }
    int wordLen = word.length();
    int row = board.length;
    int col = board[0].length;

    if (row * col < wordLen) {
      return false;
    }

    char[] wordCh = word.toCharArray();

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (wordCh[0] == board[i][j]) {
          boolean exist = isExist(board, i, j, wordCh, 0);
          if (exist) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean isExist(char[][] board, int i, int j, char[] wordCh, int start) {
    if (start == wordCh.length) {
      return true;
    }

    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
        board[i][j] != wordCh[start]) {
      return false;
    }

    board[i][j] = '#'; // mark it so that same char won't be duplicated in the word
    boolean result = isExist(board, i + 1, j, wordCh, start + 1) ||
                     isExist(board, i - 1, j, wordCh, start + 1) ||
                     isExist(board, i, j + 1, wordCh, start + 1) ||
                     isExist(board, i, j - 1, wordCh, start + 1);
    board[i][j] = wordCh[start];

    return result;
  }
}
