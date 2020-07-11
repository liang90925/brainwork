import java.util.LinkedList;
import java.util.Queue;

public class HitCounterQue {

  Queue<Integer> tsQue;

  /** Initialize your data structure here. */
  public HitCounterQue() {
    tsQue = new LinkedList<>();
  }

  /** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity).
  */
  public void hit(int timestamp) {
    tsQue.offer(timestamp);
  }

  /** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity).
  */
  public int getHits(int timestamp) {
    // Pop all the stored timestamp when it's over 5 mins
    while (!tsQue.isEmpty() && (timestamp - tsQue.peek()) >= 300) {
      tsQue.poll();
    }
    return tsQue.size();
  }
}

// This solution won't be good if there are so many counts at one timestamp. the que will need to store a lot of similar timestamps
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
