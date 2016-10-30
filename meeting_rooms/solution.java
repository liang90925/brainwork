/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Point {
  int time;
  int flag;

  public Point(int t, int f) {
    this.time = t;
    this.flag = f;
  }
  public static Comparator<Point> pointComparator = new Comparator<Point>(){
    public int compare(Point a, Point b) {
      if (a.time == b.time) {
        return (a.flag - b.flag);
      } else {
        return a.time - b.time;
      }
    }
  };
}

public class Solution {
  public boolean canAttendMeetings(Interval[] intervals) {
    if (intervals == null || intervals.length <= 1) {
      return true;
    }
    List<Point> points = new ArrayList<>();
    for (Interval interval: intervals) {
      Point pStart = new Point(interval.start, 1);
      Point pEnd = new Point(interval.end, 0);
      points.add(pStart);
      points.add(pEnd);
    }
    Collections.sort(points, Point.pointComparator);
    int count = 0 ;
    for (Point point: points) {
      if (count > 1) {
        return false;
      }
      if (point.flag == 1) {
        count++;
      } else {
        count--;
      }
    }
    return count <= 1;
  }
}
