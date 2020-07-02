import java.io.*;
import java.util.*;

/**

 Example
 Define: Empty = 0, Black = 1, White = 2

 Given board position:

 [ [0, 0, 0],
 [0, 0, 0],
 [0, 0, 0] ]

 coordinate: (0, 1)
 color: Black (1)

 Output =>
 [ [0, 1, 0],
 [0, 0, 0],
 [0, 0, 0] ]
 Given board position:

 [ [0, 1, 0],
 [0, 0, 0],
 [0, 0, 0] ]

 coordinate: (0, 1)
 color: "Black" (1)

 Output => "ERROR"

 1> Write a function that takes a 2D array board, color, and (row, col) coordinate, and outputs a new board with that position filled with that color.


 Given board position:

 [ [0, 1, 0],
 [0, 0, 0],
 [0, 0, 0] ]

 coordinate: (0, 1)

 Output => [(0, 0), (1, 1), (0, 2)]

 GROUP LIBERTIES

 Given board position:

 [ [0, 1, 0],
 [0, 1, 0],
 [0, 1, 0]
 [0, 2, 0] ]

 coordinate: (2, 1)

 Output => 6


 */


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class GoGame {
    enum State {
        EMPTY,
        BLACK,
        WHITE
    }

    private static final int[][] RANGE = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static class Board {
        State[][] board;
        int width;
        public Board(int width) {
            this.width = width;
            board = new State[width][width];

            for (State[] place: board) {
                for (int i = 0; i < width; i++) {
                    place[i] = State.EMPTY;
                }
            }
        }

        public void placeAStone(int x, int y, State stone) {
            if (stone == State.EMPTY) {
                return;
            }
            if (!isValid(x, y)) {
                return;
            }
            board[x][y] = stone;
        }

        public List<int[]> countLiberty(int x, int y) {
            List<int[]> freeSpace = new ArrayList<>();
            if (board[x][y] == State.EMPTY) {
                return freeSpace;
            }

            for (int[] range: RANGE) {
                int newX = x + range[0];
                int newY = y + range[1];
                if (isValid(newX, newY)) {
                    if (board[newX][newY] == State.EMPTY) {
                        freeSpace.add(new int[]{newX, newY});
                    }
                }
            }

            return freeSpace;
        }

        public List<int[]> countGroupLiberty(int x, int y) {
            List<int[]> freeSpace = new ArrayList<>();
            if (board[x][y] == State.EMPTY) {
                return freeSpace;
            }

            boolean[][] visited = new boolean[this.width][this.width];

            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{x, y});
            visited[x][y] = true;

            while(!que.isEmpty()) {
                int[] curr = que.poll();


                for (int[] range: RANGE) {
                    int newX = curr[0] + range[0];
                    int newY = curr[1] + range[1];

                    if (isValid(newX, newY) && visited[newX][newY]) {
                        continue;
                    }

                    if (isValidState(newX, newY, State.EMPTY) ) {
                        freeSpace.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    } else if (isValidState(newX, newY, board[curr[0]][curr[1]])) {
                        que.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }

                }
            }

            return freeSpace;

        }


        private boolean isValid(int x, int y) {
            return x >= 0 && x < this.width && y >= 0 && y < this.width;
        }

        private boolean isValidState(int x, int y, State state) {
            return isValid(x, y) && this.board[x][y] == state;
        }

    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        Board game = new Board(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(game.board[i]));
        }

        game.placeAStone(0, 0, State.WHITE);
        System.out.println(Arrays.deepToString(game.board));

        game.placeAStone(0, 1, State.BLACK);
        System.out.println(Arrays.deepToString(game.board));

        game.placeAStone(0, 1, State.EMPTY);
        System.out.println(Arrays.deepToString(game.board));

        game.placeAStone(0, 3, State.BLACK);
        System.out.println(Arrays.deepToString(game.board));

        System.out.println("==========================");


        List<int[]> freeSpace = game.countLiberty(0, 1);
        for(int[] space: freeSpace) {
            System.out.println(Arrays.toString(space));
        }


        game.placeAStone(1, 1, State.BLACK);
        game.placeAStone(2, 1, State.BLACK);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(game.board[i]));
        }

        List<int[]> groupFreeSpace = game.countGroupLiberty(1, 1);
        for(int[] space: groupFreeSpace) {
            System.out.println(Arrays.toString(space));
        }


        for (String string : strings) {
            System.out.println(string);
        }
    }
}
