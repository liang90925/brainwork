public class WordSearchRbPractice {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }

        int r = board.length;
        int c = board[0].length;

        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (found(i, j, word.substring(1), visited, board)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    private static final int[][] RANGE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >=0 && y < col;
    }
    private boolean found(int x, int y, String word, boolean[][] visited, char[][] board) {
        if (word.equals("")) {
            return true;
        }

        for (int[] range: RANGE) {
            int nx = x + range[0];
            int ny = y + range[1];
            if (!isValid(nx, ny, board.length, board[0].length)
                    || visited[nx][ny]
                    || board[nx][ny] != word.charAt(0)) {
                continue;
            } else {
                visited[nx][ny] = true;
                if (found(nx, ny, word.substring(1), visited, board)) {
                    return true;
                }
                visited[nx][ny] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WordSearchRbPractice solution = new WordSearchRbPractice();
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
