import java.util.*;

public class SlidingPuzzle {
    private static final int[] RANGE = {1, -1, 3, -3};
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    public int slidingPuzzle(int[][] board) {
        // write your code here
        int row = board.length;
        int col = board[0].length;
        if (row != 2 || col != 3) {
            return -1;
        }
        // Change board to a string
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] boardRow: board) {
            for (int item: boardRow) {
                stringBuilder.append(item);
            }
        }
        String beginWith = stringBuilder.toString();
        String target = "123450";

        Set<String> formedStr = new HashSet<>();
        formedStr.add(beginWith);
        Queue<String> que = new LinkedList<>();
        que.offer(beginWith);
        int steps = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String curr = que.poll();
                if (curr.equals(target)) {
                    return steps;
                }
                int zero = curr.indexOf("0");
                for (int j = 0; j < RANGE.length; j++) {
                    int moveTo = zero + RANGE[j];
                    // The last two statements is to avoid any movement between two layers
                    if (moveTo < 0 || moveTo > 5 || (moveTo == 2 && zero == 3) || (moveTo == 3 && zero == 2)) {
                        continue;
                    }
                    char[] newForm = curr.toCharArray();
                    newForm[zero] = newForm[moveTo];
                    newForm[moveTo] = '0';
                    String newFormStr = String.valueOf(newForm);
                    if (!formedStr.contains(newFormStr)) {
                        que.offer(newFormStr);
                        formedStr.add(newFormStr);
                    }
                }
            }
            // Note that it's better to put the step++ here;
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        slidingPuzzle.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}});
        System.out.println(slidingPuzzle.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}) + " === 1");
        System.out.println(slidingPuzzle.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}}) + " === -1");
        System.out.println(slidingPuzzle.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}}) + " === 5");
    }
}
