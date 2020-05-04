import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueSolution {
  public int findKthLargest(int[] nums, int k) {
//    Comparator<Integer> comparator = new Comparator<Integer>() {
//      @Override
//      public int compare(Integer t1, Integer t2) {
//        return t1 - t2;
//      }
//    };
    // The above stuff can be simplified to the following
    Comparator<Integer> comparator = (t1, t2) -> t1 - t2;

    PriorityQueue<Integer> pqInt = new PriorityQueue<>(comparator);
    for (int num : nums) {
      if (pqInt.size() < k) {
        pqInt.add(num);
      } else if (pqInt.peek() < num) {
        pqInt.poll();
        pqInt.add(num);
      }
    }

    // That is another good way to add stuff in the heap and make sure they are sorted and within k value
    // for (int n: nums) {
    //   heap.add(n);
    //   if (heap.size() > k)
    //     heap.poll();
    // }
    return pqInt.poll();
  }
}
