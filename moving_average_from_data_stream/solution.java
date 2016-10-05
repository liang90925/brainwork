public class MovingAverage {

  /** Initialize your data structure here. */

  Deque<Integer> dq = new ArrayDeque<>();
  private int window;
  private long sum;
  public MovingAverage(int size) {
    this.window = size;
  }

  public double next(int val) {
    if (dq.size() == window) {
      sum -= dq.pollFirst();
    }
    dq.offerLast(val);
    sum += val;

    return (double) sum/dq.size();
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
