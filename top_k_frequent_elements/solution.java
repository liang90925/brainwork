import java.util.*;
import java.util.stream.Collectors;

public class solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    // initiate the map that has key as the number in nums and value as the number occurance.
    Map<Integer, Integer> numMap = new HashMap<>();

    // Used to store the number that occurances more frequent and store them in sequence.
    PriorityQueue<Map.Entry<Integer, Integer>> numQueue = new PriorityQueue<>(
      new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> me1, Map.Entry<Integer, Integer> me2) {
            return me1.getValue() - me2.getValue();
        }
      }
    );

    List<int[]> test = new ArrayList<>();
    List<int[]> intlist = Collections.sort(test, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return 0;
      }
    });
    // pre check for input.
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }

    // construct the numMap with the number from nums array as key
    // and the number of occurance of the number as the value.
    for (int num : nums) {
      if (numMap.containsKey(num)) {
        numMap.put(num, numMap.get(num) + 1);
      } else {
        numMap.put(num, 1);
      }

    }

    // Build the PriorityQueue with size K that stores the top k frequent elements.
    for (Map.Entry<Integer, Integer> mapEntry : numMap.entrySet()) {
      if (numQueue.size() < k) {
        numQueue.add(mapEntry);
      } else if (numQueue.peek().getValue() < mapEntry.getValue()) {
        numQueue.poll();
        numQueue.add(mapEntry);
      }
    }

    // collect the key value of the elements of PriorityQueue to a list as the result.
    result = numQueue.stream()
      .map(mapEntry -> mapEntry.getKey())
      .collect(Collectors.toList());
    return result;
  }
}
