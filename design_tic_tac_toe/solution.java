
public class TicTacToe {
  private int[] rows;
  private int[] cols;
  private int diagonal;
  private int antiDiagonal;
  private int n;

  public TicTacToe(int n) {
    this.rows = new int[n];
    this.cols = new int[n];
    this.diagonal = 0;
    this.antiDiagonal = 0;
    this.n = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
      @param row The row of the board.
      @param col The column of the board.
      @param player The player, can be either 1 or 2.
      @return The current winning condition, can be either:
              0: No one wins.
              1: Player 1 wins.
              2: Player 2 wins. */
  public int move(int row, int col, int player) {
    int val = player == 1 ? 1 : -1;
    if (row == col) {
      diagonal += val;
    }
    if (row + col == (n - 1)) {
      antiDiagonal += val;
    }
    rows[row] += val;
    cols[col] += val;

    if (Math.abs(diagonal) == n ||
        Math.abs(antiDiagonal) == n ||
        Math.abs(rows[row]) == n ||
        Math.abs(cols[col]) == n) {
      return player;
    }

    return 0;
  }
}
