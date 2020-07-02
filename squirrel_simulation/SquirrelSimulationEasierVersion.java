public class SquirrelSimulationEasierVersion {
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
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        for (int[] nut : nuts) {
            int disToSquirrel = manhattanDis(nut, squirrel);

            int disToTree = manhattanDis(nut, tree);
            result += 2 * disToTree;

            minDiff = Math.min(minDiff, disToSquirrel - disToTree);
        }

        return result + minDiff;
    }

    private int manhattanDis(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

    public static void main(String[] args) {
        SquirrelSimulationEasierVersion solution = new SquirrelSimulationEasierVersion();
        System.out.println(solution.minDistance(3, 5, new int[]{0, 0}, new int[]{0, 4}, new int[][]{{2, 3}, {1, 1}, {2, 1}}) + " === 18");
        System.out.println(solution.minDistance(5, 7, new int[]{2, 2}, new int[]{4, 4}, new int[][]{{3, 0}, {2, 5}}) + " === 2");
        System.out.println(solution.minDistance(1, 3, new int[]{0, 1}, new int[]{0, 0}, new int[][]{{0, 2}}) + " === 3");
    }
}
