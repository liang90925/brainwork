import java.util.*;

public class XorSum {
    private static final int[][] RIGHT_DOWN = new int[][]{{0, 1}, {1, 0}};
    private static final int[][] LEFT_UP = new int[][]{{0, -1}, {-1, 0}};

    public class PointWithSum {
        int x;
        int y;
        long xorSum;

        public PointWithSum(int x, int y, long xorSum) {
            this.x = x;
            this.y = y;
            this.xorSum = xorSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointWithSum that = (PointWithSum) o;
            return x == that.x &&
                    y == that.y &&
                    xorSum == that.xorSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, xorSum);
        }
    }
    /**
     * @param arr: the arr
     * @param target: the target
     * @return: the sum of paths
     */
    public long xorSum(int[][] arr, int target) {
        // Write your code here.
        int row = arr.length;
        if (row == 0) {
            return 0;
        }
        int col = arr[0].length;
        if (col == 0) {
            return 0;
        }

        int mid = Math.max(col, row) - 2;
        Map<Long, Integer>[][] xorCntArray = new HashMap[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                xorCntArray[i][j] = new HashMap<>();
            }
        }
        Map<PointWithSum, Integer> pointWithSumToCntMap = new HashMap<>();
        bfsStarToMid(arr, pointWithSumToCntMap, mid);
        return bfsEndToMid(arr, pointWithSumToCntMap, mid, target);
    }

    private void bfsStarToMid(int [][] arr, Map<PointWithSum, Integer> pointWithSumToCntMap, int mid) {
        int row = arr.length;
        int col = arr[0].length;

        Queue<PointWithSum> que = new LinkedList<>();
        que.offer(new PointWithSum(0, 0, arr[0][0]));

        while (!que.isEmpty()) {
            PointWithSum curr = que.poll();
            int x = curr.x;
            int y = curr.y;
            long xorSum = curr.xorSum;
            if (x + y == mid) {
                int cnt = pointWithSumToCntMap.getOrDefault(curr, 0);
                pointWithSumToCntMap.put(curr, cnt + 1);
                continue;
            }
            for(int[] range: RIGHT_DOWN) {
                int newX = range[0] + x;
                int newY = range[1] + y;
                if (isValid(newX, newY, row, col)) {
                    que.offer(new PointWithSum(newX, newY, xorSum ^ arr[newX][newY]));
                }
            }
            ;        }
    }

    private long bfsEndToMid(int [][] arr, Map<PointWithSum, Integer> pointWithSumToCntMap, int mid, int target) {
        int row = arr.length;
        int col = arr[0].length;

        Queue<PointWithSum> que = new LinkedList<>();
        que.offer(new PointWithSum(row - 1, col - 1, arr[row - 1][col - 1]));

        long totalCnt = 0;

        while (!que.isEmpty()) {
            PointWithSum curr = que.poll();
            int x = curr.x;
            int y = curr.y;
            long xorSum = curr.xorSum;
            if (x + y == mid + 1) {
                long targetXorSum = target ^ xorSum;
                if (x - 1 >= 0) {
                    totalCnt += pointWithSumToCntMap.getOrDefault(new PointWithSum(x - 1, y, targetXorSum), 0);
                }
                if (y - 1 >= 0) {
                    totalCnt += pointWithSumToCntMap.getOrDefault(new PointWithSum(x, y - 1, targetXorSum), 0);
                }
                continue;
            }
            for (int[] range : LEFT_UP) {
                int newX = range[0] + curr.x;
                int newY = range[1] + curr.y;
                if (isValid(newX, newY, row, col)) {
                    que.offer(new PointWithSum(newX, newY, curr.xorSum ^ arr[newX][newY]));
                }
            }
        }
        return totalCnt;
    }


    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >=0 && y < col;
    }
}
