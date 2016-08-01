public class Solution {
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    dict.add(start);
    dict.add(end);
    List<List<String>> resultList =  new ArrayList<>();
    Map<String, Integer> distance = new HashMap<>();
    Map<String, List<String>> graph = new HashMap<>();

    bfs(distance, graph, start, end, dict);

    List<String> path = new ArrayList<>();

    dfs(distance, graph, path, resultList, start, end);

    return resultList;
  }

  void dfs(Map<String, Integer> distance, Map<String, List<String>> graph,
        List<String> path, List<List<String>> resultList, String current, String end){
    path.add(current);
    if(current.equals(end)){
      resultList.add(new ArrayList<>(path));
    } else {
      for(String eachWord:graph.get(current)){
        dfs(distance, graph, path, resultList, eachWord, end);
      }
    }
    path.remove(path.size() - 1);
  }
  void bfs(Map<String, Integer> distance, Map<String, List<String>> graph,
        String start, String end, Set<String> dict) {
    Queue<String> q = new LinkedList<>();
    q.offer(start);

    distance.put(start, 0);
    for (String word:dict) {
        graph.put(word, new ArrayList<>());
    }
    while(!q.isEmpty()) {
      String current = q.poll();
      List<String> matchedWords = getMatchedWords(current, dict);
      for (String  word:matchedWords) {
        if(!distance.containsKey(word) || distance.get(current) < distance.get(word)) {
          graph.get(current).add(word);
        }
        if(!distance.containsKey(word)) {
          distance.put(word, distance.get(current) + 1);
          q.offer(word);
        }
      }
    }
  }
  private List<String> getMatchedWords(String current, Set<String> dict) {
    List<String> matchedWords = new ArrayList<>();
    for(char c = 'a'; c <= 'z'; c++) {
      for(int i = 0; i < current.length(); i++) {
        if(current.charAt(i) != c) {
          String newWord = current.substring(0,i) + c + current.substring(i+1);
          if(dict.contains(newWord)) {
            matchedWords.add(newWord);
          }
        }
      }
    }
    return matchedWords;
  }
}
