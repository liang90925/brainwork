import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathII {
    private static final int[][] RANGE = {{1, 2}, {-1, 2}, {2, 1}, {-2, 1}};
    public class Point {
        private int x;
        private int y;
        public Point(){}
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        int xs = grid.length;
        if (xs == 0) {
            return 0;
        }
        int ys = grid[0].length;
        boolean[][] visited = new boolean[xs][ys];
        visited[0][0] = true;

        int step = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));

        while (queue.size() > 0) {
            // note size 要单独拎出来写！！不然会变
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                if (curr.y == ys - 1 && curr.x == xs - 1) {
                    return step;
                }
                for (int[] range: RANGE) {
                    int x = curr.x + range[0];
                    int y = curr.y + range[1];
                    if (isValid(x, y, grid, visited)) {
                        queue.offer(new Point(x, y));
                        visited[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, boolean[][] grid, boolean[][] visited) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                && !visited[x][y]
                && !grid[x][y];
    }
    public static void main(String[] args) {
        KnightShortestPathII solution = new KnightShortestPathII();
        System.out.println(solution.shortestPath2(new boolean[][]{{false,false,false,false},{false,false,false,false},{false,false,false,false}}) + " should === 3");
        System.out.println(solution.shortestPath2(new boolean[][]{{false,false,false,false},{false,false,false,false},{false,true,false,false}}) + " should === -1");
        System.out.println(solution.shortestPath2(new boolean[][]{{false, true, false},{false, false, true},{false, false, false}}) + " should === -1");

    }
}