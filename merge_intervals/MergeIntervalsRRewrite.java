import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsRRewrite {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();

        int[] merged = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (merged[1] >= intervals[i][0]) {
                merged[1] = Math.max(merged[1], intervals[i][1]);
            } else {
                result.add(merged);
                merged = intervals[i];
            }
        }

        // for (int i = 1; i < intervals.length; i++) {
        //     if (isOverlap(merged, intervals[i])) {
        //         merged = mergeTwo(merged, intervals[i]);
        //     } else {
        //         result.add(merged);
        //         merged = intervals[i];
        //     }
        // }

        result.add(merged);
        return result.toArray(new int[result.size()][]);
        // NNNNNNOTE!!! Use the above solution instead of going over the list

//        int size = result.size();
//        int[][] resultArray = new int[size][2];
//
//        for (int i = 0; i < size; i++) {
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
    }

//     private boolean isOverlap(int[] i1, int[] i2) {
//         if (i2[0] <= i1[1] && i2[1] >= i1[0]) {
//             return true;
//         }
//         return false;
//     }

//     private int[] mergeTwo(int[] i1, int[] i2) {
//         return new int[]{Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
//     }
}
