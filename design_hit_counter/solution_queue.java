
public class HitCounter {

  Queue<Integer> tsQue;

  /** Initialize your data structure here. */
  public HitCounter() {
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
    while (!tsQue.isEmpty() && (timestamp - tsQue.peek()) >= 300) {
      tsQue.poll();
    }
    return tsQue.size();
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
