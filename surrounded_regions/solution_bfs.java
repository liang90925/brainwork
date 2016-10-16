// BFS version
//thoughs:
// loop over the outside of the 2d char array;
// once we met O, change it To C(connected);
// and then use BFS to find all Os connected to the O.
// at the end, change the C to O and change O to X;

public class Solution {
  private static final char CONNECTED = 'C';
  private static final int[] moveX = {+1, -1, 0, 0};
  private static final int[] moveY = {0, 0, +1, -1};

  public static void solve(char[][] board) {
    // null, single row, single col, no need to check
    if (board == null || board.length <= 1 || board[0].length <= 1) {
      return;
    }

    int row = board.length;
    int col = board[0].length;

    // far left and far right colo
    for (int i = 0; i < row; i++) {
      bfs(board, i, 0);
      bfs(board, i, col - 1);
    }

    // top and bottom row with out first and last item
    for (int j = 1; j < col - 1; j++) {
      bfs(board, 0, j);
      bfs(board, row - 1, j);
    }

    // loop through the 2d array to change Cs;
    for (int i = 0; i < row; i ++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'C') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private static void bfs(char[][] board, int x, int y) {
    // 判断条件board[x][y] != 'O' 就可以不需要判断是不是等于X或者C
    if (board[x][y] != 'O') {
      return;
    }

    Queue<Node> nQue = new LinkedList<>();
    nQue.offer(new Node(x, y));

    while (!nQue.isEmpty()) {
      Node curr = nQue.poll();
      board[curr.x][curr.y] = CONNECTED;
      //findConnected(board, curr) 用curr node作为parameter方便，不要放原来的x, y
      for (Node  node : findConnected(board, curr)) {
        nQue.offer(node);
      }
    }
  }

  private static List<Node> findConnected(char[][] board, Node curr) {
    List<Node> nodeO =  new ArrayList<>();
    // check it's surrounding nodes and add to the List if it's O
    for (int i = 0; i < 4; i++) {
      //  一定要重新create 新的variable，不然就是在改之前（curr中的x,y）的值
      int x = curr.x + moveX[i];
      int y = curr.y + moveY[i];

      //!!!!!!!!!!!!!!!!不是简单的检查是不是等于O， 需要检查xy在不在合理的范围内!!!!!!!!
      if (x >= 0 && x < board.length &&
          y >= 0 && y < board[0].length &&
          board[x][y] == 'O') {
        // 此处的assign to C 是需要的， 因为还在for loop中；而且结果是放到List之后传给DFS 的Que 里面
        // 你不知道什么时候这个node被处理，如果有新的node在它前面被处理，就会再考虑到这个O；
        board[x][y] = CONNECTED;
        nodeO.add(new Node(x, y));
      }
    }
    return nodeO;
  }

  public static class Node {
    int x;
    int y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
