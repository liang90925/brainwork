import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalsComparator());
        List<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
          Interval curr = intervals.get(i);

          if(curr.start <= prev.end) {
            prev.end = Math.max(prev.end, curr.end);
          } else {
            result.add(prev);
            prev = curr;
          }
        }
        result.add(prev);
        return result;
    }

    private class IntervalsComparator implements Comparator<Interval> {
      public int compare(Interval a, Interval b) {
        return a.start - b.start;
      }
    }
}
