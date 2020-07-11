// This is not an optimal solution

import java.util.HashMap;
import java.util.Map;

public class HitCounterMap {

  private Map<Integer, Integer> countMap;
  public HitCounterMap() {
    this.countMap = new HashMap<>();
  }

  /*
   * @param timestamp: An integer
   * @return: nothing
   */
  public void hit(int timestamp) {
    // write your code here
    countMap.put(timestamp, countMap.getOrDefault(timestamp, 0) + 1);
  }

  /*
   * @param timestamp: An integer
   * @return: An integer
   */
  public int getHits(int timestamp) {
    // write your code here
    int total = 0;
    int prevTimestamp = Math.max(1, timestamp - 300 + 1);

    for (int i = prevTimestamp; i <= timestamp; i++) {
      if (countMap.containsKey(i)) {
        total += countMap.get(i);
      }
    }
    // remove the keys outside of past 5 mins
    // NOTE: If this part is added, the code will have TIME LIMIT EXCEEDED ERROR
    for (int i = 1; i < prevTimestamp; i++) {
      countMap.remove(i);
    }
    return total;
  }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
