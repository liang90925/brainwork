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
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

    if (intervals == null || newInterval == null) {
      return intervals;
    }

    List<Interval> result = new ArrayList<>();

    int position = 0;
    for (Interval curr:intervals) {
      if (newInterval.end < curr.start) {
        result.add(curr);
      } else if (curr.end < newInterval.start) {
        result.add(curr);
        position++;
      } else {
        newInterval.start = Math.min(newInterval.start, curr.start);
        newInterval.end = Math.max(newInterval.end, curr.end);
      }
    }
    result.add(position, newInterval);
    return result;
  }
}
