// another simpler solution;
// First, sort the list of intervals according to there start time;
// then compare the start of time with the previous end

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals == null || intervals.length <= 1) {
      return true;
    }
    // sort the intervals according to start time;
    Arrays.sort(intervals, (a, b) -> a.start - b.start);

    int end = intervals[0].end;
    // compare the end with start;
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < end) {
        return false;
      }
      end = intervals[i].end;
    }
    return true;
  }
}
