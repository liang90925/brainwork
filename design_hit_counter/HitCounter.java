// This is the best solution
public class HitCounter {

  // two int array to store timestamp and hitcount at the timestamp
  private int[] timestamps;
  private int[] hits;
  private static final int FIVE_MIN_RANGE = 300;

  /** Initialize your data structure here. */
  public HitCounter() {
    timestamps = new int[FIVE_MIN_RANGE];
    hits = new int[FIVE_MIN_RANGE];
  }

  /** Record a hit.
    @param timestamp - The current timestamp (in seconds granularity).
  */
  public void hit(int timestamp) {
    int index = timestamp % FIVE_MIN_RANGE;
    if (timestamps[index] != timestamp) {
      timestamps[index] = timestamp;
      hits[index] = 1;
    } else {
      hits[index]++;
    }
  }

  /** Return the number of hits in the past 5 minutes.
    @param timestamp - The current timestamp (in seconds granularity).
  */
  public int getHits(int timestamp) {
    int totalHits = 0;
    for (int i = 0; i < FIVE_MIN_RANGE; i++) {
      if (timestamp - timestamps[i] < FIVE_MIN_RANGE) {
        totalHits += hits[i];
      }
    }
    return totalHits;
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
