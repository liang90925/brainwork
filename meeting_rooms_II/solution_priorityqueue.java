// use priority queue to store end time
// one we have a start time >= pq.peek(), that means there is no interval of curr and prev;
// that means the two time can be put in one room, and we poll the prev end time out.
// and the size of pq(endtime) means how many rooms we need.
// O(nlog(n)) ????

public class Solution {
  public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    // sort the array according to start time
    Arrays.sort(intervals, (a,b) -> a.start - b.start);

    // creat a priority queue to store intervals end time;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(intervals[0].end);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start >= pq.peek()) {
        pq.poll();
      }
      pq.offer(intervals[i].end);
    }
    return pq.size();
  }
}
