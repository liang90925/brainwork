import java.util.HashSet;
import java.util.Set;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *   public:
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     bool move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     void turnLeft();
 *     void turnRight();
 *
 *     // Clean the current cell.
 *     void clean();
 * };
 */

public class RobotRoomCleaner {
    private static final int[][] DIRECTION_RANGE = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        // write tour code here
        dfs(robot, new HashSet<>(), 0, 0, 0);
    }

    private void dfs(Robot robot, Set<String> visited, int x, int y, int direction) {
        String position = x + "," + y;
        if (visited.contains(position)) {
            return;
        }
        visited.add(position);
        robot.clean();

        int i = 0;
        while(i++ < DIRECTION_RANGE.length) {
            if (robot.move()) {
                dfs(robot, visited, x + DIRECTION_RANGE[direction][0], y + DIRECTION_RANGE[direction][1], direction);
                backTrack(robot);
            }

            robot.turnRight();
            direction += 1;
            direction %= DIRECTION_RANGE.length;
        }
    }

    private void backTrack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
