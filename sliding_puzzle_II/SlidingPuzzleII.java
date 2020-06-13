import java.util.*;

public class SlidingPuzzleII {
    private static final int[][] RANGE = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int row;
    private int col;
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        // # write your code here
        this.row = init_state.length;
        this.col = init_state[0].length;

        String init = toStringFormat(init_state);
        String target = toStringFormat(final_state);

        Set<String> formed = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        formed.add(init);

        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr != null && curr.equals(target)) {
                    return step;
                }

                for (String nextForm : getNextForm(curr)) {
                    if (!formed.contains(nextForm)) {
                        queue.offer(nextForm);
                        formed.add(nextForm);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    private List<String> getNextForm(String curr) {
        List<String> nextFormed = new ArrayList<>();

        int zero = curr.indexOf("0");
        int zeroX = zero / col;
        int zeroY = zero % col;

        for (int[] range: RANGE) {
            int nextX = zeroX + range[0];
            int nextY = zeroY + range[1];
            if (nextX >= 0 && nextX < row && nextY >=0 && nextY < col) {
                int next = nextX * col + nextY;
                String nextStr = curr;
                nextStr = exchange(nextStr, zero, '0', next, curr.charAt(next));
                nextFormed.add(nextStr);
            }
        }
        return nextFormed;
    }

    private String exchange(String str, int index1, char c1, int index2, char c2) {
        char[] ch = str.toCharArray();
        ch[index1] = c2;
        ch[index2] = c1;
        return String.valueOf(ch);
    }

    private String toStringFormat(int[][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int[] row : matrix) {
            for (int item: row) {
                str.append(item);

            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        SlidingPuzzleII slidingPuzzleII = new SlidingPuzzleII();
        System.out.println(
                slidingPuzzleII.minMoveStep(
                        new int[][]{
                                {2,8,3},
                                {1,0,4},
                                {7,6,5}},
                        new int[][]{
                                {1,2,3},
                                {8,0,4},
                                {7,6,5}}) + "==== 4"
        );
        System.out.println(
                slidingPuzzleII.minMoveStep(
                        new int[][]{
                                {2,3,8},
                                {7,0,5},
                                {1,6,4}},
                        new int[][]{
                                {1,2,3},
                                {8,0,4},
                                {7,6,5}}) + "==== -1"
        );
    }
}
