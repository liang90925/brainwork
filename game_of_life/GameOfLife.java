import java.util.Arrays;

public class GameOfLife {
    // 00 die -> die
    // 01 live -> die
    // 10 die -> live
    // 11 live -> live
    /**
     * @param board: the given board
     * @return: nothing
     */
    /**
     * @param board: the given board
     * @return: nothing
     */
    public void gameOfLife(int[][] board) {
        // Write your code here

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int numOfLives = livesFromNeibourgh(board, i, j, row, col);

                if (board[i][j] == 0 && numOfLives == 3) {
                    board[i][j] = 2;
                } // Other wise when board[i][j] == 0 , it stays at 1

                if (board[i][j] == 1 && numOfLives >= 2 && numOfLives <= 3) {
                    board[i][j] = 3;
                } // Other wise when board[i][j] == 1 , it dies and wll be 01, so stays at 1
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
        System.out.println("==== result ====");
        System.out.println(Arrays.deepToString(board));
    }

    private int livesFromNeibourgh(int[][] board, int x, int y, int row, int col) {
        int result = 0;
        for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, row - 1); i++) {
            for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, col - 1); j++) {
                result += board[i][j] & 1; // User the first bit, which is the previous state.
            }
        }
        result -= board[x][y] & 1;
        return result;
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        });
        int[][] expected = new int[][]{
                {0,0,0},
                {1,0,1},
                {0,1,1},
                {0,1,0}
        };
        System.out.println("==== expected ====");
        System.out.println(Arrays.deepToString(expected));
    }
}
