public class Solution {
  // 全局变量

  final String START_AIRPORT = "JFK";
  public List<String> findItinerary(String[][] tickets) {
    if (tickets == null) {
      return Collections.emptyList();
    }

    Map<String, PriorityQueue<String>> flights = new HashMap<>();
    // NOTE!: 此处使用的是linkedlsit， 因为其有 addFirst的功能，如果用普通list， 最后需要reverse一下
    List<String> path = new ArrayList<>();

    //遍历input two d array to form the HashMap/graph/edge info
    for (String[] ticket : tickets) {
      flights.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
    }


    Stack<String> stack = new Stack<>();
    stack.push(START_AIRPORT);
    while (!stack.isEmpty()) {
      while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty()) {
        stack.push(flights.get(stack.peek()).poll());
      }
      path.add(0, stack.pop());
    }
    return path;
  }
}
