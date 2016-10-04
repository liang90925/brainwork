public class MovingAverage {

  /** Initialize your data structure here. */

  Deque<Integer> dq = new ArrayDeque<>();
  int window = new int;
  public MovingAverage(int size) {
    this.window = size;
  }

  public double next(int val) {
    if (dq.size() == 0 || dq.size() < window) {
      dq.offerLast(val);
    } else {
      dq.pollFirst();
      dq.offerLast(val);
    }
    int value = 0;
    Deque<Integer> temp = dq;
    while (temp.peekFirst() != null) {
      value += temp.pollFirst();
    }
    return value/dq.size();
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
