public class Solution {
  // 全局变量
  Map<String, PriorityQueue<String>> flights = new HashMap<>();
  // NOTE!: 此处使用的是linkedlsit， 因为其有 addFirst的功能，如果用普通list， 最后需要reverse一下
  // 其实用list 也可以，只要用list.add(0, element);
  LinkedList<String> path = new LinkedList<>();
  final String START_AIRPORT = "JFK";
  public List<String> findItinerary(String[][] tickets) {
    if (tickets == null) {
      return Collections.emptyList();
    }
    //遍历input two d array to form the HashMap/graph/edge info
    for (String[] ticket : tickets) {
      flights.putIfAbsent(ticket[0], new PriorityQueue<>());
      flights.get(ticket[0]).add(ticket[1]);
    }
    // dfs to the end and add the airport to the first of the path when trace back
    dfs(START_AIRPORT);
    return path;
  }

  public void dfs(String departure) {
    PriorityQueue<String> arrivals = flights.get(departure);
    while (arrivals != null && !arrivals.isEmpty()) {
      dfs(arrivals.poll());
    }
    path.addFirst(departure);
  }
}
