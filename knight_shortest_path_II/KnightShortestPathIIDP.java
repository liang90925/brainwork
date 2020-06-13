import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathIIDP {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        int xs = grid.length;
        if (xs == 0) {
            return -1;
        }
        int ys = grid[0].length;
        if (ys == 0) {
            return -1;
        }

        int[][] minVal = new int[xs][ys];
        for (int i = 0; i < xs; i++) {
            for (int j = 0; j < ys; j++) {
                minVal[i][j] = Integer.MAX_VALUE;
            }
        }
        minVal[0][0] = 0;
        for (int j = 1; j < ys; j++) {
            for (int i = 0; i <xs; i++) {
                if (grid[i][j]) {
                    continue;
                }
                if (i >= 1 && j >= 2 && minVal[i - 1][j - 2] != Integer.MAX_VALUE) {
                    minVal[i][j] = Math.min(minVal[i][j], minVal[i - 1][j - 2] + 1);
                }
                if (i + 1 < xs && j >= 2 && minVal[i + 1][j - 2] != Integer.MAX_VALUE) {
                    minVal[i][j] = Math.min(minVal[i][j], minVal[i + 1][j - 2] + 1);
                }
                if (i >= 2 && minVal[i - 2][j - 1] != Integer.MAX_VALUE) {
                    minVal[i][j] = Math.min(minVal[i][j], minVal[i - 2][j - 1] + 1);
                }
                if (i + 2 < xs && minVal[i + 2][j - 1] != Integer.MAX_VALUE) {
                    minVal[i][j] = Math.min(minVal[i][j], minVal[i + 2][j - 1] + 1);
                }
            }
        }

        return minVal[xs - 1][ys - 1] == Integer.MAX_VALUE ? -1 :  minVal[xs - 1][ys - 1];
    }

    public static void main(String[] args) {
        KnightShortestPathIIDP solution = new KnightShortestPathIIDP();
        System.out.println(solution.shortestPath2(new boolean[][]{{false,false,false,false},{false,false,false,false},{false,false,false,false}}) + " should === 3");
        System.out.println(solution.shortestPath2(new boolean[][]{{false,false,false,false},{false,false,false,false},{false,true,false,false}}) + " should === -1");
        System.out.println(solution.shortestPath2(new boolean[][]{{false, true, false},{false, false, true},{false, false, false}}) + " should === -1");
    }
}