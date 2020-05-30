import javafx.util.Pair;

import java.util.*;

public class ShortestPathToTheDestinationBFS {

    private static  final int[] xRange = new int[]{0, 1, -1, 0};
    private static  final int[] yRange = new int[]{1, 0, 0, -1};

    /**
     * @param targetMap:
     * @return: nothing
     */
    public int shortestPath(int[][] targetMap) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0});

        int rowCnt = targetMap.length;
        int colCnt = targetMap[0].length;

        int[][] steps = new int[rowCnt][colCnt];
        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < colCnt; j++) {
                steps[i][j] = -1;
            }
        }
        steps[0][0] = 0;

        while(!que.isEmpty()) {
            int[] currPnt = que.poll();
            int x = currPnt[0];
            int y = currPnt[1];
            for (int i = 0; i< 4; i++) {
                int newX = x + xRange[i];
                int newY = y + yRange[i];
                if (newX >= 0 && newX < rowCnt && newY >=0 && newY < colCnt
                        && targetMap[newX][newY] != 1
                        && steps[newX][newY] == -1) {
                    steps[newX][newY] = steps[x][y] + 1;
                    if (targetMap[newX][newY] == 2) {
                        return steps[newX][newY];
                    }
                    que.add(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }
    private int checkNeighbour(int[][] targetMap, int[][] passableMap, int row, int col) {
        if (row < 0 || row >= targetMap.length || col < 0 || col >= targetMap[0].length) {
            return Integer.MAX_VALUE;
        }
        if (targetMap[row][col] == 2 || passableMap[row][col] <= 0) {
            return Integer.MAX_VALUE;
        }
        return passableMap[row][col] + 1;
    }

    private int getValueFromNeighbour(int up, int left, int right, int down) {
        int min = Math.min(up, Math.min(left, Math.min(right, down)));
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        ShortestPathToTheDestinationBFS shortestPathToTheDestination = new ShortestPathToTheDestinationBFS();
        System.out.println("=====================");
        int output = shortestPathToTheDestination.shortestPath(
                new int[][]{
                        {0, 0, 0},
                        {0, 0, 1},
                        {0, 0, 2}
                }
        );
        System.out.println(output);

        System.out.println("=====================");
        int output1 = shortestPathToTheDestination.shortestPath(
                new int[][]{
                        {0, 1},
                        {0, 1},
                        {0, 0},
                        {0, 2}
                }
        );
        System.out.println(output1);

        System.out.println("=====================");
        int output2 = shortestPathToTheDestination.shortestPath(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0},
                        {1, 1, 2, 1, 0},
                        {1, 0, 0, 0, 0}
                }
        );
        System.out.println(output2);

    }
}
