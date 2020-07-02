import com.sun.tools.javac.code.Attribute;

public class SquirrelSimulation {
    /**
     * @param height: the height
     * @param width: the width
     * @param tree: the position of tree
     * @param squirrel: the position of squirrel
     * @param nuts: the position of nuts
     * @return: the minimal distance
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        // Write your code here
        int firstSquirrelMove = -1;
        int minDiff = Integer.MAX_VALUE;
        int[][] dis = new int[2][nuts.length]; // 0 for tree, 1 for squirrel

        for (int i = 0; i < nuts.length; i++) {
            dis[0][i] = manhattanDis(nuts[i], tree);
            dis[1][i] = manhattanDis(nuts[i], squirrel);
            int diff = dis[1][i] - dis[0][i];
            if (diff < minDiff) {
                firstSquirrelMove = i;
                minDiff = diff;
            }
        }

        int result = 0;
        for (int i = 0; i < nuts.length; i++) {
            if (firstSquirrelMove == i) {
                result += dis[1][i];
                result += dis[0][i];
            } else {
                result += 2 * dis[0][i];
            }
        }
        return result;
    }

    private int manhattanDis(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

    public static void main(String[] args) {
        SquirrelSimulation solution = new SquirrelSimulation();
        System.out.println(solution.minDistance(3, 5, new int[]{0, 0}, new int[]{0, 4}, new int[][]{{2, 3}, {1, 1}, {2, 1}}) + " === 18");
        System.out.println(solution.minDistance(5, 7, new int[]{2, 2}, new int[]{4, 4}, new int[][]{{3, 0}, {2, 5}}) + " === 2");
        System.out.println(solution.minDistance(1, 3, new int[]{0, 1}, new int[]{0, 0}, new int[][]{{0, 2}}) + " === 3");
    }
}
