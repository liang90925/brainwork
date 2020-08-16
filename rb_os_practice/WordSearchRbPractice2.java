public class WordSearchRbPractice2 {
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
                if (board[i][j] == word.charAt(0)) {
                    if (found(i, j, 0, visited, word.toCharArray(), board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean found(int x, int y, int idx, boolean[][] visited, char[] words, char[][] board) {
        if (idx == words.length) {
            return true;
        }
        if (!isValid(x, y, board.length, board[0].length)
                || visited[x][y]
                || board[x][y] != words[idx]) {
            return false;
        } else {
            visited[x][y] = true;
        }

        boolean result = found(x + 1, y, idx + 1, visited, words, board)
                || found(x, y + 1, idx + 1, visited, words, board)
                || found(x - 1, y, idx + 1, visited, words, board)
                || found(x, y - 1, idx + 1, visited, words, board);

        visited[x][y] = false;
        return result;
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >=0 && y < col;
    }

    public static void main(String[] args) {
        WordSearchRbPractice2 solution = new WordSearchRbPractice2();
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
