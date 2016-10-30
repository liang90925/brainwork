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
   public List<Interval> merge(List<Interval> intervals) {
     if (intervals == null || intervals.isEmpty()) {
       return intervals;
     }
     // sort intervals according to the start time
     Collections.sort(intervals, (a, b) -> (a.start - b.start));

     List<Interval> result = new ArrayList<>();
     Interval prev = intervals.get(0);
     for (int i = 1; i < intervals.size(); i++) {
       if (intervals.get(i).start > prev.end) {
         result.add(prev);
         prev = intervals.get(i);
       } else {
         prev.end = Math.max(prev.end, intervals.get(i).end);
       }
     }
     result.add(prev);
     return result;
   }
 }
