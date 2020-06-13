import java.util.*;

public class TheMinimumDistance {
    private static final int[][] RANGE = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public class Point {
        private int rowIdx;
        private int colIdx;
        public Point(){}
        public Point(int rowIdx, int colIdx) {
            this.rowIdx = rowIdx;
            this.colIdx = colIdx;
        }
    }
    /**
     * @param mazeMap: a 2D grid
     * @return: return the minium distance
     */
    public int getMinDistance(int[][] mazeMap) {
        int rowCnt = mazeMap.length;
        if (rowCnt == 0) {
            return 0;
        }
        int colCnt = mazeMap[0].length;

        // Initialize the transmissionDoor and get the starting point
        Point start = new Point();
        Map<Integer, List<Point>> transmissionDoor = new HashMap<>();
        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < colCnt; j++) {
                if (mazeMap[i][j] == -2) {
                    start = new Point(i, j);
                }
                if (mazeMap[i][j] > 0) {
                    List<Point> points = transmissionDoor.getOrDefault(mazeMap[i][j], new ArrayList<>());
                    points.add(new Point(i, j));
                    transmissionDoor.put(mazeMap[i][j], points);
                }
            }
        }

        boolean[][] visited = new boolean[rowCnt][colCnt];
        Queue<Point> que = new LinkedList<>();
        visited[start.rowIdx][start.colIdx] = true;
        que.offer(start);

        int step = -1;
        while(que.size() > 0) {
            step++;
            for (int i = 0; i < que.size(); i++) {
                Point curr = que.poll();
                int valInMaze = mazeMap[curr.rowIdx][curr.colIdx];
                // Check for the destination
                if (valInMaze == -3) {
                    return step;
                }

                // TRANSMISSION
                if (transmissionDoor.containsKey(valInMaze)) {
                    List<Point> points = transmissionDoor.get(valInMaze);
                    for (Point point: points) {
                        que.offer(point);
                        visited[point.rowIdx][point.colIdx] =  true;
                    }
                    transmissionDoor.remove(valInMaze);
                }

                // NEIGHBOURS
                for (int[] range : RANGE) {
                    int x = curr.rowIdx + range[0];
                    int y = curr.colIdx + range[1];
                    if (isValid(x, y, mazeMap, visited)) {
                        visited[x][y] = true;
                        que.offer(new Point(x, y));
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int x, int y, int[][] mazeMap, boolean[][] visited) {
        return x >= 0 && x < mazeMap.length && y >= 0 && y < mazeMap[0].length
                && !visited[x][y]
                && mazeMap[x][y] != -1;
    }

    public static void main(String[] args) {
        TheMinimumDistance solution = new TheMinimumDistance();
        int val1 = solution.getMinDistance(new int[][]{{1,0,-1,1},{-2,0,1,-3},{2,2,0,0}});
        int val2 = solution.getMinDistance(new int[][]{{1,0,-1,-1},{-2,0,-1,-3},{2,2,0,0}});
        System.out.println(val1 + " should === 3");
        System.out.println(val2 + " should === 5");
    }
}
