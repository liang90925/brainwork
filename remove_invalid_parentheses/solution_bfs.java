// BFS please complete

public class Solution {
  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();

    Queue<String> sq = new LinkedList<>();
    sq.add(s);
    Map<String, Integer> visited = new HashMap<>();
    boolean found = false;

    while(!sq.isEmpty()) {
      
      String curr = sq.poll();
      if (isValidParentheses(curr)) {
        result.add(curr);
        found = true;
      }
      if (found) continue;
      for (int i = 0; i < curr.length(); i++) {
        if (curr.charAt(i) != '(' && curr.charAt(i) != ')') {
          continue;
        }
        String newStr = curr.substring(0,i) + curr.substring(i + 1);
        if (!visited.containsKey(newStr)) {
          visited.put(newStr, 1);
          sq.add(newStr);
        }
      }
    }
    return result;
  }
  private boolean isValidParentheses(String s) {
   int leftCount = 0;
   int rightCount = 0;
   for (int i = 0; i < s.length(); i++) {
     if (s.charAt(i) == '(') {
       leftCount++;
     } else if (s.charAt(i) == ')') {
       rightCount++;
     }
     if (rightCount > leftCount) {return false;}
   }
   return leftCount == rightCount;
 }
}
