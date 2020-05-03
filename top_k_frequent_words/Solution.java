class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> wordsMap = new HashMap<>();
    // Build a <words: "happy" -> num: 3> Map
    for (String word : words) {
      wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
    }

    // Build a comparator to be used by priority queue
    Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String, Integer>>(){
      @Override
      public int compare(Map.Entry<String, Integer> me1, Map.Entry<String, Integer> me2) {
        // Desending order for the String when value is the same, so that Strings in the later part of the alphebatic order will be polled first.
        if (me1.getValue() == me2.getValue()) {
          return me2.getKey().compareTo(me1.getKey());
        }
        // Ascending order for the value, so that the lower valued will be poll first
        return me1.getValue().compareTo(me2.getValue());
      }
    };
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(comp);

    // Add items to the priority queue;
    for (Map.Entry<String, Integer> mapEntry: wordsMap.entrySet()) {
      if (pq.size() < k) {
        pq.add(mapEntry);
      } else {
        Map.Entry<String, Integer> peeked = pq.peek();
        if (comp.compare(peeked, mapEntry) < 0)  {
          pq.poll();
          pq.add(mapEntry);
        }
      }
    }

// Output the items from the priority queue to a list by polling the items;
// Two options here: Use a LinkedList and addFirst() or Use a normal list, add and then reverse();
    // OPTION 1
    LinkedList<String> result = new LinkedList<>();
    Map.Entry<String, Integer> polled;
    while((polled = pq.poll()) != null) {
      result.addFirst(polled.getKey());
    }
    // OPTION 2
    // List<String> result = new ArrayList<>();
    // Map.Entry<String, Integer> polled;
    // while((polled = pq.poll()) != null) {
    //     result.add(polled.getKey());
    // }
    // // Reverse the list to get the right order.
    // Collections.reverse(result);


    return result;
  }
}