public class Solution{
  public String rearrangeString(String str, int k) {

    if (str == null || str.length() == 0 || k <= 0) {
      return str;
    }
    //first get a map to store char as the key and number of the chars appeared in the str as value
    // build the map
    Map<Character, Integer> chCountMap = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      chCountMap.put(c, chCountMap.getOrDefault(c, 0) + 1);
    }

    // Put the map into the priorityQueue
    // that has the higher count of accurance at the top
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
      public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
        return entry2.getValue() - entry1.getValue();
      }
    });
    maxHeap.addAll(chCountMap.entrySet());

    // wait queue is defined here to store the already visited chars
    // and when they are k apart, put them back to the pq to be polled
    Queue<Map.Entry<Character, Integer>> waitQue = new LinkedList<>();

    StringBuilder sb = new StringBuilder();

    while(!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> curr = maxHeap.poll();
      sb.append(curr.getKey());

      curr.setValue(curr.getValue() - 1);
      waitQue.offer(curr);
      // Note the condition here.
      if (waitQue.size() < k) {
        continue;
      }
      Map.Entry<Character, Integer> prev = waitQue.poll();
      if (prev.getValue() > 0) {
        maxHeap.offer(prev);
      }
    }
    // NOTE!!!!!! need to compare the length of sb and str to determine
    // whether we can seperate them by k distance
    // NOTE!!!!!! StringBuilder HAS length(), not size()
    return sb.length() == str.length() ? sb.toString() : "";
  }
}
