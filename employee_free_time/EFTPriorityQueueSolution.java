import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class EFTPriorityQueueSolution {
  static class ScheduleInx {
    public int empInx;
    public int intervalInx;

    public ScheduleInx() {}

    public ScheduleInx(int _empInx, int _intervalInx) {
      empInx = _empInx;
      intervalInx = _intervalInx;
    }
  }
  // Definition for an Interval.
  static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  };

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

    List<Interval> result = new ArrayList<>();
    PriorityQueue<ScheduleInx> pqSchInx = new PriorityQueue<>(
            Comparator.comparingInt(s -> schedule.get(s.empInx).get(s.intervalInx).start));

    int i = 0;
    int anchor = Integer.MAX_VALUE;
    for (List<Interval> workSchedule : schedule) {
      // Put the first array of workSchedule into pq and find the smallest start value
      pqSchInx.offer(new ScheduleInx(i++, 0));
      anchor = Math.min(anchor, workSchedule.get(0).start);
    }
    // Poll from pqSchInx one by one
    while(!pqSchInx.isEmpty()) {
      ScheduleInx currScheduleInx = pqSchInx.poll();
      Interval currInterval = schedule.get(currScheduleInx.empInx).get(currScheduleInx.intervalInx);
      // If there are spaces from anchor to current Interval, add the freeSpace to the result.
      if (anchor < currInterval.start) {
        result.add(new Interval(anchor, currInterval.start));
      }

      // Move anchor to the next location
      anchor = Math.max(anchor, currInterval.end);

      // If the students still have an interval, push it to the pq.
      if (++currScheduleInx.intervalInx < schedule.get(currScheduleInx.empInx).size()) {
        pqSchInx.offer(currScheduleInx);
      }
    }
    return result;
  }
}
