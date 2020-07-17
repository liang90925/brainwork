import java.util.*;

public class MergeIntervalsLinkedList {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> result = new LinkedList<>();

        result.add(intervals[0]);
        for (int[] interval: intervals) {
            if (result.getLast()[1] >= interval[0]) {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
