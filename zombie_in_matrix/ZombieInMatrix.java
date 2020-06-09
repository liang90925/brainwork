import javafx.geometry.Pos;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZombieInMatrix {

    public class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final int[][] RANGE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // write your code here

        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int col = grid[0].length;

        int pplCnt = 0;
        Queue<Position> que = new LinkedList<>();

        for (int i= 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    que.offer(new Position(i, j));
                }
                if (grid[i][j] == 0) {
                    pplCnt++;
                }
            }
        }
        if (que.size() == 0) {
            return -1;
        }
        int times = 0;

        while (que.size() > 0) {
            times++;
            int numOfZombies = que.size();
            for (int i = 0; i < numOfZombies; i++) {
                Position currentZombie = que.poll();
                for (int[] range : RANGE) {
                    int x = currentZombie.x + range[0];
                    int y = currentZombie.y + range[1];
                    if (validXY(x, y, row, col) && grid[x][y] == 0) {
                        que.offer(new Position(x, y));
                        grid[x][y] = 1; // this is very important, don't forget to mark it as 1;
                        pplCnt--;
                    }
                    if (pplCnt == 0) {
                        return times;
                    }
                }
            }
        }
        if (pplCnt > 0) {
            return -1;
        } else {
            return times;
        }
    }

    private boolean validXY(int x, int y, int row, int col) {
        return x>=0 && x < row && y>=0 && y < col;
    }

    public static void main(String[] args) {
        ZombieInMatrix zombieInMatrix = new ZombieInMatrix();
        System.out.println(zombieInMatrix.zombie(new int[][]{{0,1,2,0,0},{1,0,0,2,1},{0,1,0,0,0}}) + " === 2");
        System.out.println(zombieInMatrix.zombie(new int[][]{{0,0,0},{0,0,0},{0,0,1}}) + " === 4");
    }
}
