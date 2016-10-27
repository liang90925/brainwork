/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

// define a class named Point to store two information
// 1. the time
// 2. the flag; 0->landing, 1->take off (since landing is before take off, so the value is 0 for landing)
class Point {
  int time;
  int flag;
  public Point(int time, int flag) {
    this.time = time;
    this.flag = flag;
  }
  // Define a comparator
  public static Comparator<Point> PointComparator = new Comparator<Point>() {
    public int compare(Point p1, Point p2) {
      if (p1.time == p2.time) {
        return p1.flag - p2.flag;
      } else {
        return p1.time - p2.time;
      }
    }
  };
}

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
  public int countOfAirplanes(List<Interval> airplanes) {
    if (airplanes == null) {
      return 0;
    }

    List<Point> points = new ArrayList<>(airplanes.size()*2);
    for (Interval interval : airplanes) {
      points.add(new Point(interval.start, 1));
      points.add(new Point(interval.end, 0));
    }

    Collections.sort(points, Point.PointComparator);

    int ans = 0;
    int count = 0;

    for (Point point : points) {
      if (point.flag == 1) {
        count++;
      } else {
        count--;
      }
      ans = Math.max(count, ans);
    }
    return ans;
  }
}
