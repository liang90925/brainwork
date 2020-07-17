
// use priority queue
// time complexity: addNum -> O(log(n)); getMedian -> O(1)

import java.util.Collections;
import java.util.PriorityQueue;


// Time complexity O(5*Log(n)) + O(1) At worst case, there are three heap insertions and two heap deletions.
// Space Complexity O(n) linear space to hold input in containers

public class MedianFinder {
  // maxHeap stores the lower half with highest value at top;
  // and the size of it will be equal to minHeap or 1 size larger
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  // minHeap stores the higher half with smallest value at the top
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  // Add a number into the data structure;
  public void addNum(int num) {
    // NOTE: understand that the manipulation is used to
    // make sure that the maxHeap size is always = or 1 > than the minHeap size
    maxHeap.add(num);
    minHeap.add(maxHeap.poll());
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  // returns the median of current data stream
  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      // NOTE: Remember to use (double) for casting
      // or "return (maxHeap.peek() + minHeap.peek()) * 0.5; "
      return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    } else {
      return maxHeap.peek();
    }
  }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
