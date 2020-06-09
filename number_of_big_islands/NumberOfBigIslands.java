import java.util.LinkedList;
import java.util.Queue;

public class NumberOfBigIslands {
    /**
     * @param grid: a 2d boolean array
     * @param k: an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if ( k > row*col) {
            return 0;
        }

        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                if (!grid[i][j] || visited[i][j]) {
                    continue;
                }
                int size = bfs(grid, visited, i, j);
                if (size >= k) {
                    count++;
                }
            }
        }
        return count;
    }

    private static  final int[][] RANGE = {{1, 0}, {-1, 0}, {0, 1} ,{0, -1}};

    private int bfs(boolean[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        // Go through each direction to find islands
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int count = 1;
        while(queue.size() > 0) {
            int[] coord = queue.poll();
            for (int[] range: RANGE) {
                int x = coord[0] + range[0];
                int y = coord[1] + range[1];
                if (valid(grid, x, y) && !visited[x][y]) {
                    visited[x][y] = true;
                    count++;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return count;
    }

    private boolean valid(boolean[][] grid, int x, int y) {
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y];
    }

    public static void main(String[] args) {
        NumberOfBigIslands solution = new NumberOfBigIslands();
        System.out.println(solution.numsofIsland(
                new boolean[][]{
                        {true, true, false, false, false},
                        {false, true, false, false, true},
                        {false, false, false, true, true},
                        {false, false, false, false, false},
                        {false, false, false, false, true}
                },
                2
        ) + " ======== 2");

        System.out.println(solution.numsofIsland(
                new boolean[][]{
                        {true, false},
                        {false, true}
                },
                1
        ) + " ======== 2");
    }
}
