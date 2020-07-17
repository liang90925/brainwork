import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 public class MergeIntervalRewrite {
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
     int[][] intervalsdsf = new int[2][2];
     Arrays.sort(intervalsdsf, Comparator.comparingInt(a -> a[0]));
     // sort intervals according to the start time
     intervals.sort(Comparator.comparingInt(a -> a.start));

     int[] numbers = new int[2];
     Set<Integer> numSet = Arrays.stream(numbers).boxed().collect(Collectors.toSet());

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
