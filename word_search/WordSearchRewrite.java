public class WordSearchRewrite {
  public boolean exist(char[][] board, String word) {
    if (word == null || word.length() == 0) {
      return true;
    }
    if (board == null || board.length == 0) {
      return false;
    }

    int r = board.length;
    int c = board[0].length;

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] == word.charAt(0)) {
          boolean[][] visited = new boolean[r][c];
          visited[i][j] = true;
          if (findWord(word.substring(1), i, j, visited, board)) {
            return true;
          }
          visited[i][j] = false;
        }
      }
    }

    return false;
  }
  private static final int[][] RANGE = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

  private boolean findWord(String word, int x, int y, boolean[][] visited, char[][] board) {
    if (word.isEmpty()) {
      return true;
    }

    for (int[] range: RANGE) {
      int nx = range[0] + x;
      int ny = range[1] + y;
      if (isValidRange(nx, ny, word.charAt(0), visited, board)) {
        visited[nx][ny] = true;
        boolean found = findWord(word.substring(1), nx, ny, visited, board);
        if (found) {
          return true;
        }
        visited[nx][ny] = false;
      }
    }
    return false;
  }

  private boolean isValidRange(int x, int y, char target, boolean[][] visited, char[][] board) {
    return x >= 0 && y >= 0
            && x < board.length && y < board[0].length
            && board[x][y] == target
            && !visited[x][y];
  }

  public static void main(String[] args) {
    WordSearchRewrite solution = new WordSearchRewrite();
    char[][] dict = new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
    };

    System.out.println(solution.exist(dict, "ABCCED") + " ==== true");
    System.out.println(solution.exist(dict, "SEE") + " ==== true");
    System.out.println(solution.exist(dict, "ABCB") + " ==== false");

    System.out.println(solution.exist( new char[][]{
            {'a', 'a'}}, "aaa") + " ==== false");

    char[][] dict2 = new char[][]{
            {'A','B','C','E'},
            {'S','F','E','S'},
            {'A','D','E','E'}
    };
    System.out.println(solution.exist(dict2, "ABCESEEEFS") + " ==== true");

  }
}
