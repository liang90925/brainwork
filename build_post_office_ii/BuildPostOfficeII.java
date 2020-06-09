import javafx.geometry.Pos;

import java.util.*;

public class BuildPostOfficeII {
    private static final int[][] RANGE = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here
        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int col = grid[0].length;

        // Form houses, empty, and new matrix in the form of Position
        List<Position> houses = new ArrayList<>();
        List<Position> empty = new ArrayList<>();
        Position[][] newForm = new Position[row][col];
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Position(i, j));
                }
                if (grid[i][j] == 0) {
                    empty.add(new Position(i, j));
                }
                newForm[i][j] = new Position(i, j);
            }
        }

        for (Position house: houses) {
            // dfs to Update the empty blocks with steps used and reachBy houses
            bfs(grid, newForm, house);
        }

        int min = Integer.MAX_VALUE;
        for (Position position: empty) {
            Position updatedPosition = newForm[position.x][position.y];
            if (updatedPosition.reachBy == houses.size()) {
                min = Math.min(min, updatedPosition.steps);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] grid, Position[][] newForm, Position house) {
        Queue<Position> que = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[house.x][house.y] = true;
        que.offer(house);
        int steps = 0;
        while (que.size() >0) {
            steps++;
            int queSize = que.size();
            for (int i = 0; i < queSize; i++) {
                Position position = que.poll();
                for (int[] range : RANGE) {
                    int x = position.x + range[0];
                    int y = position.y + range[1];
                    if (validEmptyPlace(grid, x, y) && !visited[x][y]) {
                        visited[x][y] = true;
                        newForm[x][y].steps += steps;
                        newForm[x][y].reachBy++;
                        que.offer(newForm[x][y]);
                    }
                } // 4 directions
            }// one BFS level
        } // while for all levels
    }

    private boolean validEmptyPlace(int[][] grid, int x, int y) {
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==0;
    }

    public class Position {
        int x;
        int y;
        int steps;
        int reachBy;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            this.steps = 0;
            this.reachBy = 0;
        }
    }

    public static void main(String[] args) {
        BuildPostOfficeII solution = new BuildPostOfficeII();
        System.out.println(solution.shortestDistance(new int[][]{{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}}) + " ==== 8");
        System.out.println(solution.shortestDistance(new int[][]{{0,1,0},{1,0,1},{0,1,0}}) + " ==== 4");


    }
}
